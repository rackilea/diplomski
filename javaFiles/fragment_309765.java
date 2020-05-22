public static String[] method(String[] stringArray) {
    String[] biggerStringArray = new String[stringArray.length * 2];

    System.arraycopy(stringArray, 0, biggerStringArray, biggerStringArray.length / 2, stringArray.length);

    for (int i = 0; i < biggerStringArray.length; i++) {
      System.out.print(biggerStringArray[i] + ", ");
    }
    return biggerStringArray;
  }