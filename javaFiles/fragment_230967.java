public static void main(String[] args) {
    // prints [[2, 6, 7, 0, 1]]
    System.out.println(mergeSets(sets(set(0, 1, 2, 6), set(2, 6, 7))));
    // prints [[3, 4, 5], [0, 2, 6, 1, 7]]
    System.out.println(
      mergeSets(sets(set(0, 1, 2), set(0, 2, 6), set(3, 4, 5), set(2, 6, 7))));
}