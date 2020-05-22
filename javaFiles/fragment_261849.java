try (Scanner in = new Scanner(System.in)) {
  while (in.hasNextLine()) {
    try {
      String line = in.nextLine();
      Scanner lineScan = new Scanner(line);
      BigDecimal moneyInput = lineScan.nextBigDecimal();
      String currency = lineScan.next();
      // do something
    } catch (NoSuchElementException | IllegalStateException e) {
      System.err.print("Please enter the VALUE followed by the CURRENCY");
    }
  }
}