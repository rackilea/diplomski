private static void listPairs(Set<Integer> set, int target) {
    System.out.print(target + ": ");
    Set<Integer> used = new HashSet<>();
    for (Integer value1 : set)
        if (! used.contains(value1)) {
            Integer value2 = target - value1;
            if (! value2.equals(value1) && set.contains(value2)) {
                used.add(value1);
                used.add(value2);
                System.out.print("(" + value1 + "," + value2 + ")");
            }
        }
    System.out.println();
}
public static void main(String[] args) {
    Set<Integer> set = new HashSet<>(Arrays.asList(1,2,3,4,5,6));
    listPairs(set, 7);
    listPairs(set, 6);
    listPairs(set, 5);
}