class TestThread$1 implements Runnable {
  private final List<String> list;

  TestThread$1(List<String> list) {
    this.list = list;
  }

  @Override
  public void run() {
    System.out.println(list);
  }
}