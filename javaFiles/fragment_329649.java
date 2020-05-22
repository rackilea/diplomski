public class CarReg {
  public boolean canAddCar(Car car) {
    // logic for testing if you can add the car, for example:
    return (car.getOwner().toString().equals("pete"));
  }
}

public class Car {
  public boolean addCar(CarReg carReg, Car car) {
    if (carReg.canAddCar(car)) {
      // ...
    } else {
      // ...
    }
  }
}