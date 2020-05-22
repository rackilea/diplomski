List<Data> allItems = ...
List<Data> filtered = new ArrayList<>();
for (Data d : allItems) {
    boolean allPass = true;
    for (Map.Entry<String,String> entry : propertyMap.entrySet()) {
        Method m = d.getClass().getMethod(entry.getKey());
        if (m == null || !entry.getValue().equals(m.invoke(d))){
            allPass = false;
            break;
        }
    }
    if (allPass) {
        filtered.add(d);
    }
}