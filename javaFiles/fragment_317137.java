public List<Object> doSomethingList(int param) {
    ListHandler handler = new ListHandler();
    doSomethingGeneric(param, handler);
    return handler.list;
}

public Map<Object, Object> doSomethingMap(int param) {
    MapHandler handler = new MapHandler();
    doSomethingGeneric(param, handler);
    return handler.map;
}

private void doSomethingGeneric(int param, CollectionHandler handler) {
    for (int i = 0; i < param; i++) {
        handler.handle("Hello");
    }
}
private interface CollectionHandler {
    void handle(String string);
}

private static class MapHandler implements CollectionHandler {
    public final Map<Object, Object> map = new HashMap<Object, Object>();

    @Override
    public void handle(String string) {
        map.put(string, string);
    }
}

private static class ListHandler implements CollectionHandler {
    public final List<Object> list = new ArrayList<Object>();

    @Override
    public void handle(String string) {
        list.add(string);
    }
}