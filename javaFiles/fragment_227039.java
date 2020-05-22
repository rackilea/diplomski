public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>(Arrays.asList(new Integer[] {1, 3, 5, 6, 9}));
    System.out.format("Input : %s%n", list);
    list = removeUntil(list, 3);
    System.out.format("Output: %s%n", list);
}