Class Son extends Base {

  private static boolean getMyBoolean(int num) {
    return num > 17; //or any complex algorithm you need.
  }

  public Son (int num) {
    super(num, getMyBoolean(num));
  }
  ...
}