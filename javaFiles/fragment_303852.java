double parseDouble(String s) throws NumberFormatException {
  try {
    return Double.valueOf(s);
  } catch (NumberFormatException e) {
    if (s.equalsIgnoreCase("nan")) {
      return Double.NaN;
    } else if (s.equalsIgnoreCase("inf") || s.equalsIgnoreCase("+inf")) {
      return Double.POSITIVE_INFINITY;
    } else if (s.equalsIgnoreCase("-inf")) {
      return Double.NEGATIVE_INFINITY;
    } else {
      throw e; // Invalid string
    }
  }
}