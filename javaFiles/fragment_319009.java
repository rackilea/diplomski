public static int sumUniqueElements(int[] arr) {
    Map<Integer, Boolean> map = new HashMap<>();
    int sum = 0;

    for (int val : arr) {
        if (map.containsKey(val)) {
            if (map.get(val) == Boolean.TRUE) {
                sum -= val;
                map.put(val, Boolean.FALSE);
            }
        } else {
            sum += val;
            map.put(val, Boolean.TRUE);
        }
    }

    return sum;
}