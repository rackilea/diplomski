public <T extends IdSize> List<Comparator<T>> sort(Map<String, String> map) {
    List<Comparator<T>> list = new ArrayList<Comparator<T>>();
    for (Map.Entry<String, String> entry : map.entrySet()) {
        boolean sortOrder = entry.getValue().equalsIgnoreCase("asc");
        Comparator<T> comparator = null;
        switch (entry.getKey()) {
            case "id":
                comparator = Comparator.comparing(IdSize::getId);
                break;
            case "size":
                comparator = Comparator.comparing(IdSize::getSize);
                break;
            default: // do something here, throw an exception?
        }
        list.add(sortOrder ? comparator : comparator.reversed());
    }
    return list;
}