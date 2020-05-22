double part1;
try {
  part1 = Double.parseDouble(parts[0]);
} catch(NumberFormatException e) {
  System.err.println("The first argument was not a number.");
  System.exit(1);
}