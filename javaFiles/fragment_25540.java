public <T,U> Map<T, U> toMap(List<Pair<T, U>> aList) {
    Map<T, U> myMap = new HashMap<>();
    for (Pair<T, U> aPair : aList) {
        myMap.put(aPair.getLeft(), aPair.getRight());
    }
    return myMap;
}