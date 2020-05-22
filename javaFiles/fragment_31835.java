public static Class<?> inputType(Scanner scanner) {
  if (scanner.hasNextFloat()) {
    return Float.class;
  else if (scanner.hasNextInt()) {
    return Integer.class;
  }
  // add other types as needed
  return String.class;
}

public static void main(String[] args) {
  try (Scanner scanner = new Scanner(System.in)) {
    Class<?> inputType = inputType(scanner);
    String input = scanner.next();
    System.out.println("You input: " + input);
    if (inputType.equals(Integer.class)) {
      System.out.prinln("That's a valid integer!");
    }
  }
}