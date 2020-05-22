Matcher m = MONEY_PATTERN.matcher(line);
if (m.matches()) {
  BigDecimal moneyInput = new BigDecimal(m.group(1));
  String currency = m.group(2);
// do something
} else {
  System.err.println("Please enter the VALUE followed by the CURRENCY");
}