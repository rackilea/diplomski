public static void main(String[] args) {
    System.out.println(isDateInRange(1, 2,
                                     11, 24,
                                     3, 3));
    System.out.println(isDateInRange(11, 25,
                                     11, 24,
                                     3, 3));
    System.out.println(isDateInRange(1, 2,
                                     1, 1,
                                     3, 3));
    System.out.println(isDateInRange(1, 22,
                                     1, 21,
                                     1, 25));
}