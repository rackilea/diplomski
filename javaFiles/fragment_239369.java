Scanner scanner = new Scanner(dataEntry.getText());
if (scanner.hasNextFloat()) {
  firstEntry = scanner.nextFloat();
} else {
  // input is not a float
}