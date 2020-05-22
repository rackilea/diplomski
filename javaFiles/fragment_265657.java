Map<Class<? extends DbObject>, Map<Long, ? extends DbObject>> registry = /*...*/;

<T extends DbObject> Map<Long, T> getRegistryMap(Class<T> clazz) {
    return (Map<Long, T>) registry.get(clazz);
}

<T extends DbObject> T get(Class<T> clazz, Long id) {
    Map<Long, T> map = getRegistryMap(clazz);

    return (map == null) ? null : map.get(id);
}

<T extends DbObject> T put(Class<T> clazz, Long id, T obj) {
    Map<Long, T> map = getRegistryMap(clazz);

    if (map == null) {
        map = new HashMap<>();
        registry.put(clazz, map);
    }
    return map.put(id, obj);
}