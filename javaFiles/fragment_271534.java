@Test
  public void test() {
    String[] input = new String[] { "user", "client", "client", "user", "client", "user", "client", "client",
        "client" };
    for (Integer[] i : doFun(input, "client")) {
      System.out.println("(" + i[0] + "," + i[1] + ")");
    }

  }