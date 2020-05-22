private boolean isParseDoubleOk(String value) {
    try {
      String str = value.replace(",", "");
      Double.parseDouble(str);
      return true;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }