public class CopyOnWriteWeakReferenceSet<E> extends AbstractSet<E> {

    private static final long serialVersionUID = -3127064371410565215L;

    private CopyOnWriteArraySet<WeakReference<E>> items;

    public CopyOnWriteWeakReferenceSet() {
        items = new CopyOnWriteArraySet<WeakReference<E>>();
    }

    public CopyOnWriteWeakReferenceSet(Collection<E> c) {
        items = new CopyOnWriteArraySet<WeakReference<E>>();
        addAll(c);
    }

    public boolean add(E element) {
        if (contains(element)) return false;
        return items.add(new WeakReference<E>(element));
    }

    @Override
    public boolean remove(Object o) {
        boolean removed = false;
        E element = null;
        for (WeakReference<E> ref : items) {
            element = ref.get();
            if (element != null && element.equals(o)) {
                ref.clear();
                removed = true;
                break;
            }
        }
        if (removed) removeReleased();
        return removed;
    }

    @Override
    public boolean contains(Object o) {
        List<E> list = new ArrayList<E>();
        for (WeakReference<E> ref : items) {
            if (ref.get() != null) {
                list.add(ref.get());
            }
        }
        boolean contains = list.contains(o);
        list.clear();
        list = null;
        return contains;
    }

    public int size() {
        removeReleased();
        return items.size();
    }

    private void removeReleased() {
        for (WeakReference<E> ref : items) {
            if (ref.get() == null) {
                items.remove(ref);
            }
        }
    }

    @Override
    public Iterator<E> iterator() {
        final Iterator<WeakReference<E>> iter = items.iterator();
        return new Iterator<E>() {

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }

            @Override
            public E next() {
                return iter.next().get();
            }

            @Override
            public void remove() {
                iter.remove();
            }
        };
    }

    public static void main(String[] args) {
        CopyOnWriteWeakReferenceSet<String> set = new 
                              CopyOnWriteWeakReferenceSet<String>();
        set.add("3");
        set.add("1");
        set.add("2");
        set.add("1");

        //testing iterator multiple times
        System.out.println("----------------------------");
        System.out.println("Iterator test start");
        System.out.println("----------------------------");
        for (String str : set) {
            System.out.println(str);
        }
        System.out.println("----------------------------");
        for (String str : set) {
            System.out.println(str);
        }
        System.out.println("----------------------------");
        for (String str : set) {
            System.out.println(str);
        }
        System.out.println("----------------------------");
        //Trying iteration using iterator object 
        Iterator<String> strIter = set.iterator();
        while(strIter.hasNext()) {
            System.out.println(strIter.next());
            //This remove call will throw 
            //java.lang.UnsupportedOperationException 
            //even on the original CopyOnWriteArraySet.
            //strIter.remove();
        }
        System.out.println("----------------------------");
        System.out.println("Iterator test end");

        System.out.println("----------------------------");

        System.out.println("----------------------------");
        System.out.println("Remove test start");
        System.out.println("----------------------------");
        System.out.println("Set size now " + set.size());
        set.remove("3");
        System.out.println(set.contains("3")); //false
        for (String str : set) {
            System.out.println(str); //1 and 2
        }
        System.out.println("Set size now " + set.size()); //2
        System.out.println("----------------------------");
        System.out.println("Remove test end");
        System.out.println("----------------------------");
    }
}