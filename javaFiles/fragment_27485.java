interface TimeChangeable {
   long getTimeChanged();
}
public class TimeChangeableSet<E extends TimeCheangeable> implements Set<E> {

    private final HashMap<Integer,E> hashMap = new HashMap<Integer,E>();

    @Override
    public boolean add(E e) {
        E existingValue = hashMap.remove(e.hashCode());
        if(existingValue==null){
            hashMap.put(e.hashCode(),e);
            return true;
        }
        else{
            E toAdd = e.getTimeChanged() > existingValue.getTimeChanged() ? e : existingValue;
            boolean newAdded = e.getTimeChanged() > existingValue.getTimeChanged() ? true : false;
            hashMap.put(e.hashCode(),e);
            return newAdded;
        }

    }

    @Override
    public int size() {
        return hashMap.size();
    }

    @Override
    public boolean isEmpty() {
        return hashMap.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return hashMap.containsKey(o.hashCode());
    }

    @Override
    public Iterator<E> iterator() {
        return hashMap.values().iterator();
    }

    @Override
    public Object[] toArray() {
        return hashMap.values().toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return hashMap.values().toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return removeAndGet(o)!=null ? true : false;
    }

    public E removeAndGet (Object o) {
        return hashMap.remove(o.hashCode());
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean containsAll = true;
        for(Object object:c){
            E objectInMap = removeAndGet(object);
            if(objectInMap==null || !objectInMap.equals(object))
                containsAll=false;
        }
        return containsAll;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean  addAll=true;
        for(E e:c){
            if(!add(e)) addAll=false;
        }
        return addAll;

    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean setChanged=false;
        for(E e: hashMap.values()){
            if(!c.contains(e)){
                hashMap.remove(e.hashCode());
                setChanged=true;
            }
        }
        return setChanged;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Please do not use type-unsafe methods in 2012");
    }

    @Override
    public void clear() {
        hashMap.clear();
    }




}