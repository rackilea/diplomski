for (DataType dt: toSort) {
    List<DataType> list = data.get(dt.dType);
    if (list == null) {
        list = new ArrayList<>();
        data.put(dt.dType, list);
    }
    list.add(dt);
}