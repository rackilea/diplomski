import static java.util.Arrays.asList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class MergingIterator<T> implements Iterator<T> {

    public static class InputIter<T> {
        final Iterator<T> source;
        T data;

        public InputIter(Iterable<T> list) {
            source = list.iterator();
            read();
        }

        public void read() {
            if (source.hasNext()) {
                data = source.next();
            } else {
                data = null;
            }
        }
    }

    final PriorityQueue<InputIter<T>> queue;

    public MergingIterator(final Comparator<? super T> cmp, Iterable<T>... lists) {
        queue = new PriorityQueue<InputIter<T>>(lists.length, new Comparator<InputIter<T>>() {
            @Override
            public int compare(InputIter<T> o1, InputIter<T> o2) {
                return cmp.compare(o1.data, o2.data);
            }
        });
        for (Iterable<T> list : lists) {
            InputIter<T> ii = new InputIter<T>(list);
            if (ii.data != null) {
                queue.add(ii);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public T next() {
        InputIter<T> ii = queue.poll();
        T next = ii.data;
        ii.read();
        if (ii.data != null) {
            queue.add(ii);
        }
        return next;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}