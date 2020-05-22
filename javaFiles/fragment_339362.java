class T1 {
  public static void main(String[] s) {
    System.setProperty("dummy.property", "42");

    // Keep printing value of "dummy.property" forever.
    while (true) {
      System.out.println(System.getProperty("dummy.property"));
      try {
        Thread.sleep(500);
      } catch (Exception e) {}
    }
  }
}

class T2 {
  public static void main(String[] s) {
    System.setProperty("dummy.property", "52");

    // Keep printing value of "dummy.property" forever.
    while (true) {
      System.out.println(System.getProperty("dummy.property"));
      try {
        Thread.sleep(500);
      } catch (Exception e) {}
    }
  }
}