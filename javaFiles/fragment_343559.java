public class Garage {

  public static void main(String ... args) {
    List<Car> myGarage = new ArrayList<>();
    myGarage.add(new Car("CG404GH", "John"));
    System.out.println(myGarage);
    for(Car car : myGarage) {
        if("CG404GH".equals(car.getRegistration())) {
            myGarage.remove(car);
            Car updateCar = new Car("DD404GH", "John");
            myGarage.add(updateCar);
        }
    }
    System.out.println(myGarage);
  }

}