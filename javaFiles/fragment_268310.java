public class IdentityTreeSet<T extends Comparable> extends AbstractCollection<T> {

    private SortedMap<T, Set<T>> values = new TreeMap<>();

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Iterator<Set<T>> outerIterator = values.values().iterator();
            Set<T> currentSet = Collections.newSetFromMap(new IdentityHashMap<>());
            Iterator<T> innerIterator = currentSet.iterator();

            @Override
            public boolean hasNext() {
                return innerIterator.hasNext() || outerIterator.hasNext();
            }

            @Override
            public T next() {
                if (innerIterator.hasNext()) {
                    return innerIterator.next();
                } else {
                    currentSet = outerIterator.next();
                    innerIterator = currentSet.iterator();
                    return next();
                }
            }

            @Override
            public void remove() {
                innerIterator.remove();
                if (currentSet.isEmpty()) {
                    outerIterator.remove();
                }
            }

        };
    }

    @Override
    public int size() {
        int i = 0;
        for (Set<T> set : values.values()) {
            i += set.size();
        }
        return i;
    }

    @Override
    public boolean add(T e) {
        Set<T> entrySet = values.get(e);

        if (entrySet == null) {
            Set<T> newSet = Collections.newSetFromMap(new IdentityHashMap<>());
            newSet.add(e);
            values.put(e, newSet);
            return true;
        } else {
            return entrySet.add(e);
        }
    }

    @Override
    public boolean remove(Object o) {
        Set<T> entrySet = values.get(o);

        if (entrySet == null) {
            return false;
        } else {
            boolean removed = entrySet.remove(o);
            if (entrySet.isEmpty()) {
                values.remove(o);
            }
            return removed;
        }
    }

}