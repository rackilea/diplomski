Map<Integer, String[]> treeMap = new TreeMap<Integer, String[]>(new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2) {
            return 1;
        } else if (o1 > o2) {
            return -1;
        } else {
            return 0;
        }
    }
});
treeMap.putAll(hashMap);

System.out.println(treeMap); // Descending