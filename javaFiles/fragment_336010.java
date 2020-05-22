interface TestInterface {
  void doFirst();
  void doSecond();

  TestInterface EMPTY = new TestInterface() {
    @Override
    public void doFirst() {}
    @Override
    public void doSecond() {}
  };

}