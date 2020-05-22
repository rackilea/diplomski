public class SmallCar extends AbstractCar {

  private static final int FUEL_CAPACITY = 45;

  public SmallCar() {
    // we set the value in the parent class
    super(FUEL_CAPACITY);
  }

  public int drive() {
    // HERE goes the logic for drive for SmallCar. Same method is needed
    // in the LargeCar class, because the logic differes.
  }

  // HERE goes the rest of the code

}