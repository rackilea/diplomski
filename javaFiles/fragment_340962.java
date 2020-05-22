final int x = getValue();

private int getValue() {
  try {
    return Integer.parseInt("someinput");
  }
  catch(NumberFormatException e) {
    return 42;
  }
}