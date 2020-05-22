class Shared {

  private int y = 0;
  private volatile int x = 0;

  public void setOne() {
    y = 1; //(1)
    x = 1; //(2)
  }

  public int getY() {
    return y; //(3)
  }
}