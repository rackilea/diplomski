class SingleInstanceSet<T> {

    Map<Class<? extends T>, T> map = new HashMap<Class<? extends T>, T>();

    public boolean add(T o) {

        if (map.containsKey(o.getClass()))
            return false;

        map.put((Class<? extends T>) o.getClass(), o);
        return true;
    }

    public T get(Class<? extends T> klass) {
        return map.get(klass);
    }
}