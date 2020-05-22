int[] list = {1, 3, 3, 1, 4};
HashMap<Integer, ArrayList<Integer>> listsMap = new HashMap<>();
for (int i: list) {
    if (!listsMap.containsKey(i)) {
        listsMap.put(i, new ArrayList<>());
        listsMap.get(i).add(i);
    } else {
        listsMap.get(i).add(i);
    }
}
System.out.println(listsMap);