static class HandleCache {
    private final Map<Data, Integer> handles = new HashMap<>();
    private final List<Data> dataByIndex = new ArrayList<>();

    synchronized int getHandle(Data data) {
        Integer id = handles.get(data);
        if (id == null) {
             id = handles.size();
             handles.put(data, id);
             dataByIndex.add(id);
        }
        return id;
    }

    synchronized Data getData(int handle) {
        return dataByIndex.get(handle);
    }
}