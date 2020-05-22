public static void main(String[] args) throws FileNotFoundException {
    int[] arrayWithMajorityElements = {3,3,4,2,4,4,2,4,4};

    Integer[] majorityElements = getMajorityElements(arrayWithMajorityElements);
    System.out.println(Arrays.toString(majorityElements));
    // result = 4

    int[] arrayWithoutMajorityElements = {3,3,4,2,4,4,2,4};
    majorityElements = getMajorityElements(arrayWithoutMajorityElements);
    System.out.println(Arrays.toString(majorityElements));
    // result = empty array (ie no majory elements)
}

private static Integer[] getMajorityElements(int[] array) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : array) {
        int count = 0;
        if (map.containsKey(i)) {
            count = map.get(i);
        }
        map.put(i, ++count);
    }

    List<Integer> majorityElements = new ArrayList<>();
    int check = array.length / 2;
    for (Integer i : map.keySet()) {
        if (map.get(i) > check) {
            majorityElements.add(i);
        }
    }
    return majorityElements.toArray(new Integer[majorityElements.size()]);
}