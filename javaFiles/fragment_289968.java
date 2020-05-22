class Shared {

  private int y = 0;
  private volatile int x = 0;

  public void setOne() {
    y = 1; //(1)
    x = 1; //(2)
  }

  public int getXPlusY() {
    int local = x; //(3)
    return local + y; //(4)
  }
}