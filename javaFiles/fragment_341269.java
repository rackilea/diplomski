public static Integer majority(int[] array) {
    Map<Integer, Integer> count = new HashMap<Integer, Integer>();
    for (int number : array) {
        if (count.containsKey(number)) {
        count.put(number, count.get(number) + 1);
        } else {
        count.put(number, 1);
        }
    }
    Integer majority = null;
    Integer majorityCount = null;
    for (Integer key : count.keySet()) {
        if (count.get(key) > array.length / 2) {
        majority = key;
        majorityCount = count.get(key);
        }
    }
    return majority;
}