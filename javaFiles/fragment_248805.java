public static void main() {
    final
    HashMap<String, HashMap<String, Integer>> map = new HashMap<String, HashMap<String, Integer>>();

    String[] keys = (String[]) map.keySet().toArray();

    Arrays.sort(keys, new Comparator<String>() {
        @Override
        public int compare(String k1, String k2) {
            int v1 = numberOfTasks(map.get(k1));
            int v2 = numberOfTasks(map.get(k2));
            return Integer.valueOf(v1).compareTo(Integer.valueOf(v2));
        }
    });

    // 'keys' is now sorted the way you want.

}

public static int numberOfTasks(HashMap<String, Integer> map) {
    int max = 0;
    for (Integer i : map.values()) {
        if (i > max) max = i;
    }
    return max;
}