class FlyingCar extends Car {
  private Car regularCarDelegate;

  void takeOff() {
    // logic
  }
  @Override void accelerate() {
    // delegate to the regular car's accelerate()
    regularCarDelegate.accelerate();
  }
}