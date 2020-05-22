public static void main(String[] args) {
    int[] listA = { 0, 1, 2 };
    int[] listB = { 0, 1, 2, 3, 4 };
    for (List<Integer> seq : orderings(listA, listB))
        System.out.println(seq);
}