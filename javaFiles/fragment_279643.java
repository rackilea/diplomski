List<Car> cars = //...

Function<Car, String> carsToNames = new Function<Car, String>() {
   @Override
   public String apply(Car car) {
      return car.getName();
   }
}

List<String> names = Lists.transform(cars, carsToNames);