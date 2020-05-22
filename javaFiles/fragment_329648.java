public class Car {
  public boolean canAddCar(CarReg carReg, Car car) {
    // logic for checking if you can add the car
  }
  public boolean addCar(CarReg carReg, Car car) { 
    if (canAddCar(carReg, car)) {
      // logic for adding the car goes here
      return true;
    } else {
      // anything special if you can't add the car?
      return false;
    }
  }
}