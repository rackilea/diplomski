if ("help".equals(args[0])) {
  System.out.println("Enter a number between 1 and 5 to play.");
}
else {
  int number;
  try {
    number = Integer.parseInt(args[0]);
  }
  catch (NumberFormatException ex) {
    System.out.println("Input is not an integer: " + args[0]);
    return;
  }
  if ((number < 1) || (number > 5)) {
    System.out.println("Number out of bounds: " + number);
    return;
  }
  int r = new java.util.Random().nextInt(5) + 1;
  if (number == r)
    System.out.println("You won!");
  else
    System.out.println("You lost!");
}