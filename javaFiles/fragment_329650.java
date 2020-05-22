// might as well use an interface if you'll have multiple methods of checking
public interface CarChecker {
  boolean canAddCar(CarReg carReg, Car car);
}

// specific implementation of the CarChecker interface
// you can instantiate this and pass it into the Car class via a setter
public class MyCarChecker implements CarChecker {
  public boolean canAddCar(CarReg carReg, Car car) {
    // checking logic goes here
  }
}

public class Car {
  private CarChecker carChecker;
  // you'll have to implent getCarChecker and setCarChecker 
  // (or let your IDE generate the getters and setters)

  // assuming you'll call setCarChecker somewhere (or have it wired up via IoC)

  public boolean addCar(CarReg carReg, Car car) {
    if (carChecker.canAddCar(carReg, car)) {
      // ...
    } else {
      // ...
    }
  }
}