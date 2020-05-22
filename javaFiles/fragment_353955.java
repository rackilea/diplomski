public static boolean recursiveMethod(int x) {
    if (x >= 5) {
      return true;
    }
    Exception e = new Exception();
    e.fillInStackTrace();
    if (e.getStackTrace().length == 2) {
      System.out.println("Printed once!"); // Print this statement only once
    }
    return recursiveMethod(x + 1);
  }

  public static void main(String[] args) {
    System.out.println(recursiveMethod(0));
  }