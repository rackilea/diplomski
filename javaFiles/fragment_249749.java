BasicDBObject updateObject = new BasicDBObject();
BasicDBList dbCarList = mapCars(cars);
updateObject.append("$push", new BasicDBObject("cars", dbCarList));

...
private BasicDBList mapCars(List<Car> cars) {
  BasicDBList result = new BasicDBList();
  for (Car car: cars) {
    BasicDBObject dbCar = new BasicDBObject();
    dbCar.append("name", car.getName());
    result.add(dbCar);
  }

  return result;
}