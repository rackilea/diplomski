public static void main(String[] args) {
    test(Arrays.asList(1,2,3,4,5), 2);
    test(Arrays.asList(1,2,3,4,5,6,7), 3);
}
private static void test(List<Integer> list, int groups) {
    System.out.println("Split of " + list + " into " + groups + " groups:");
    for (List<List<Integer>> combo : split(list, groups)) {
        String sep = "  ";
        for (List<Integer> group : combo) {
            System.out.print(sep + group);
            sep = ", ";
        }
        System.out.println();
    }
}