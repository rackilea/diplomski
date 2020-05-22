private static void displayNumbers(int minInclusive, int maxInclusive) {
    List<Integer> list = new ArrayList<Integer>();
    for (int i = minInclusive; i <= maxInclusive; i++) {
        list.add(i);
    }
    Collections.shuffle(list);
    for (int value : list) {
        System.out.println(value);
    }
}