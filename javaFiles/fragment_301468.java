private Collection<MyData> trim(List<MyData> data) {
    Map<String, MyData> result = new HashMap<>();
    for (MyData item : data) {
        MyData lastItem = result.get(item.getKey());
        if (lastItem == null || lastItem.getDate().before(item.getDate())) {
            result.put(item.getKey(), item);
        }
    }
    return result.values();
}