public static void main(String[] args) throws FileNotFoundException {
    Scanner input = new Scanner(new File("integers.txt"));

    List<Integer> numbers = new ArrayList();

    while (input.hasNextInt()) {
        numbers.add(input.nextInt());
    }

    numbers.forEach(System.out::println);
}