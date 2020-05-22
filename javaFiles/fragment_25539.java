List<Pair<String, Integer>> mylist;

Map<String, Integer> myMap = new HashMap<>();
for (Pair<String, Integer> aPair : mylist) {
    myMap.put(aPair.getLeft(), aPair.getRight());
}