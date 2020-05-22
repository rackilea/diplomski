private static final String STATEMENT = "This input is of type ";

public static String checkInput(Scanner scanner) {
  if (scanner.hasNextFloat()) {
    return STATEMENT + Float.class.getSimpleName();
  else if (scanner.hasNextInt()) {
    return STATEMENT + Integer.class.getSimpleName();
  }
  return STATEMENT + "UNKNOWN";
}