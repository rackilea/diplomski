static double inputDouble(Scanner input) {
  while (input.hasNext()) try {
    return input.nextDouble();
  }
  catch (InputMismatchException e) {
    System.out.println("Wrong input. Try again.");
    input.next(); // consume the invalid double
  }
  throw new IOException("Input stream closed");
}