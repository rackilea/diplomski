class MyRandom {
  private Random random = new Random(DateTime.Now.Ticks);

  public void setSeed(long seed) {
    random = new Random(seed * this.random.next());
    ...

  public long next() {
    return random.next();
}

class MyClass {
  private MyRandom random = new MyRandom();
  public void Test() {
    random.setSeed(seedValue);
    int x = random.next();
    random.setSeed(seedValue);
    int y = random.next();
    // x,y will be different in most of the cases now
  }
}