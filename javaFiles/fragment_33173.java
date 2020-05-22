private static <T> void addToListInMap(Map<Integer,ArrayList<T>> map, Integer keyValue, T itemToAdd {
    ArrayList<T> listOfItems = map.get(keyValue);
    if (listOfItems == null) {
       listOfItems = new ArrayList<T>();
       map.put(keyValue, listOfItems);
    }
    listOfItems.add(itemToAdd);
}