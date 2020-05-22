public class Car {
  private Wheels wheels;
  // other properties

  public boolean equals(Object ob) {
    if (!(ob instanceof Car)) return false;
    Car other = (Car)ob;
    // compare properties
    if (!wheels.equals(other.wheels)) return false;
    return true;
  }
}