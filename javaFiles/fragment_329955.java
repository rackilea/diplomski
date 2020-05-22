public static double parse(String str) throws ParseException {
  NumberFormat formatter = NumberFormat.getInstance();
  ParsePosition position = new ParsePosition(0);
  Number number = formatter.parse(str, position);
  if (position.getIndex() != str.length()) {
    throw new ParseException("failed to parse entire string: " + str, position.getIndex());
  }
  return number.doubleValue();
}