public static int[] sortByValueAndIndex(int[] array) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int[] result = new int[array.length];
    for (int i = 0; i < array.length; i++) {
        int temp = array[i] * (i + 1);
        map.put(array[i], temp);
    }

    List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
    Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
        public int compare(Map.Entry<Integer, Integer> o1,
                           Map.Entry<Integer, Integer> o2) {
            return (o1.getValue()).compareTo(o2.getValue());
        }
    });

    int i = 0;
    for (Map.Entry<Integer, Integer> l : list) {
        result[i] = l.getKey();
        i++;
    }
    return result;
}