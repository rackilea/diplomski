class ClassToHandler {
    private Map<Class<? extends IV2GraphObject>, Handler<? extends IV2GraphObject>> map
        = HashMap<>();

    @SuppressWarnings("unchecked")
    public <T extends IV2GraphObject> Handler<T> get(Class<T> clazz) {
        return (Handler<T>)map.get(clazz);
    }

    public <T extends IV2GraphObject> void put(Class<T> clazz, Handler<T> handler) {
        map.put(clazz, handler);
    }
}