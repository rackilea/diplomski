public class LazyList<T> implements List<T> {

private SQLQuery query;
private long size = 0;
private int limit = 100;

private Expression<T> exprsn;
private int offset = 0;
private List<T> cache = new ArrayList<>();

public LazyList(SQLQuery query, Expression<T> exprsn) {
    this.query = query;
    this.exprsn = exprsn;
    size = query.count();
    cache = query.limit(limit).offset(offset).list(exprsn);
}

@Override
public int size() {
    return (int) size;
}

@Override
public boolean isEmpty() {
    return size == 0;
}

@Override
public T get(int index) {
    if (index < offset || index > offset + limit) {
        cache = query.limit(limit).offset(offset).list(exprsn);
    }
    return cache.get(index - offset);
}

@Override
public Iterator<T> iterator() {
    return new Iterator<T>() {

        private int index = 0;
        private int offset = 0;
        private List<T> cache = new ArrayList<>();

        {
            cache = query.limit(limit).offset(offset).list(exprsn);
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (index < offset || index > offset + limit) {
                cache = query.limit(limit).offset(offset).list(exprsn);
            }
            return cache.get(index - offset);
        }
    };
}

@Override
public boolean contains(Object o) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public Object[] toArray() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public <T> T[] toArray(T[] a) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean add(T e) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean remove(Object o) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean containsAll(Collection<?> c) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean addAll(Collection<? extends T> c) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean addAll(int index, Collection<? extends T> c) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean removeAll(Collection<?> c) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public boolean retainAll(Collection<?> c) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public void clear() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public T set(int index, T element) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public void add(int index, T element) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public T remove(int index) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public int indexOf(Object o) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public int lastIndexOf(Object o) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public ListIterator<T> listIterator() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public ListIterator<T> listIterator(int index) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

@Override
public List<T> subList(int fromIndex, int toIndex) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
}

}