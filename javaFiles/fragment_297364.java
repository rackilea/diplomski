public static void print(SortedMap<Integer, int[]> map, PrintWriter writer) {
    int last = 1;
    for (int key : map.keySet()) {
        for (int i = last + 1; i < key; i++) {
            writer.println();
        }
        last = key;
        writer.println(Arrays.toString(map.get(key)));
    }
}