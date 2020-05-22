public static void main(String[] args) {
  // using try-with-resources so we don't have to call .close()
  try (Scanner scanner = new Scanner(System.in)) {
    System.out.println(checkInput(scanner));
    String input = scanner.next(); // this actually advances the scanner
    System.out.println("You input: " + input);
  }
}