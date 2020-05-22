import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import junit.framework.TestCase;

public class ConcurrentlyAddableListTest extends TestCase {


    public void testAdd() throws Exception {
        List<String> list = new ConcurrentlyAddableList<String>();
        list.add("apple");
        list.add("banana");
         Iterator<String> a = list.iterator();
         Iterator<String> b = list.iterator();
         b.next();
         Iterator<String> c = list.iterator();
         c.next();
         c.next();
         list.add("cherry");
         assertEquals("apple", a.next());
         assertEquals("banana", b.next());
         assertEquals("cherry", c.next());
    }


    private static class ConcurrentlyAddableList<T> extends PureListWrapper<T> {
        private final Set<WrappedIterator<T>> iterators = new HashSet<WrappedIterator<T>>();

        @Override
        public Iterator<T> iterator() {
            WrappedIterator<T> iterator = new WrappedIterator<T>(super.iterator());
            iterators.add(iterator);
            return iterator;
        }

        @Override
        public synchronized boolean add(T o) {
            final HashSet<WrappedIterator<T>> set = new HashSet<WrappedIterator<T>>(iterators);
            for (WrappedIterator<T> iterator : set)
                iterator.rememberPosition(this);
            boolean result = super.add(o);
            for (WrappedIterator<T> iterator : set)
                iterator.restorePosition(this);
            return result;
        }
    }

    private static class WrappedIterator<T> extends PureIteratorWrapper<T> {
        private int index = 0;

        public WrappedIterator(Iterator<T> iterator) {
            super(iterator);
        }

        @Override
        public T next() {
            index++;
            return super.next();
        }

        public void restorePosition(List<T> list) {
            setIterator(list.iterator());
            int prevIndex = index;
            index = 0;
            while (index < prevIndex)
                next();
        }

        public void rememberPosition(List<T> list) {
            setIterator(null);
        }

    }
}