public static void main(String[] args) {
    String[] stringArray = new String[] {"one", "two", "three"};
    method(stringArray);
  }

  public static String[] method(String[] stringArray) {
    String[] biggerStringArray = new String[stringArray.length * 2];

    for (int i = 0; i < stringArray.length; i++) {
      biggerStringArray[i + biggerStringArray.length / 2] = stringArray[i];
    }

    for (int i = 0; i < biggerStringArray.length; i++) {
      System.out.print(biggerStringArray[i] + ", ");
    }
    return biggerStringArray;
  }