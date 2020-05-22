public abstract class AbstractCar implements Car {
  // this is the common variable
  // that is why we save it in the parent class
  private int fuelCapacity;

  private int fuelLevel;

  // we forward the value to the parent constructor with the super call
  public AbstractCar(int fuelCapacity) {
    this.fuelCapacity = fuelCapacity;
    // I set the value to 0 for the start, but
    // you can also pass the value to the super call,
    // same as fuelCapacity - it is up to you
    this.fuelLevel = 0;
  }

  // The getters and setter allow us to retrieve the values
  // from the abstract class through capsulation!

  // here we have the getter to be able to retrieve the value from SmallCar and LargeCar
  public int getFuelCapacity() {
    return.fuelCapacity;
  }

  public void setFuelCapacity(int fuelCapacity) {
    this.fuelCapacity = fuelCapacity;
  }

  protected int getFuelLevel() {
    return fuelLevel;
  }

  protected void setFuelLevel(int fuelLevel) {
    this.fuelLevel = fuelLevel;
  }

  // HERE goes the rest of the code

}