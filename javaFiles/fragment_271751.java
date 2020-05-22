public static void inLoop() {
    while (true) {
      byte[] one = new byte[21];
      byte[] two = new byte[50];
      byte[] three = new byte[30];
    }
  }

  public static void outsideLoop() {
    byte[] one;
    byte[] two;
    byte[] three;
    while (true) {
      one = new byte[21];
      two = new byte[50];
      three = new byte[30];
    }
  }