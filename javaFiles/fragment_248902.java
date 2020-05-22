public static void main(String[] argu) {
    List<Integer> i = new ArrayList<>();
    Scanner sc = new Scanner(System.in);
    for (int j = 0; j <= 9; j++) {
        i.add(Integer.valueOf(sc.nextLine()));
    }

    System.out.println("Sorted:");
    Collections.sort(i);
    i.forEach(System.out::println);

    System.out.println("\nReversed:");
    Collections.sort(i, Collections.reverseOrder());
    i.forEach(System.out::println);
}