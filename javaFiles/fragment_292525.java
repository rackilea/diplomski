public static void main() {
    List<Car> cars = new ArrayList<Car>();
    cars.add(new Volvo());
    cars.add(new BMW());
    foreach(Car c:cars)
        c.checkCar();
}