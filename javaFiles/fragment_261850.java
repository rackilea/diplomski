String[] parts = line.split("\\s+");
if (parts.length == 2) {
  BigDecimal moneyInput = new BigDecimal(parts[0]);
  String currency = parts[1];
  // do something
} else {
  System.err.println("Please enter the VALUE followed by the CURRENCY");
}