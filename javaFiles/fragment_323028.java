public static void main(String args[]) throws FileNotFoundException {
    List<Integer> x = new ArrayList<>();
    List<Integer> y = new ArrayList<>();
    try (Scanner scanner = new Scanner(new File("input.txt"))) {
        while (scanner.hasNext()) {
            x.add(scanner.nextInt());
            y.add(scanner.nextInt());
            scanner.nextLine();

        }
    }
    System.out.println(x);
    System.out.println(y);
}