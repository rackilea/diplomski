public Test() { GenerateNum(); }
  public void schedule(int sec) {
    timer = new Timer();
    timer.schedule(new NumUser(), seconds * 1000);
  }
  public static void main(String[] args) {
    new Test().schedule(5);
  }