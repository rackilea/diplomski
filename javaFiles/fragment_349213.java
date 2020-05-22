public T Get(Class<T> clazz, String key) throws Exception {
    if (this.instance.containsKey(key)) {
        return this.instance.get(key);
    } 
    T item = clazz.getDeclaredConstructor(String.class).newInstance(key);
    instance.put(key, item);
    return item;
}