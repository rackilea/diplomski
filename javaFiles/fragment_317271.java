obj2Arr = obj2Arr.stream()
        .map(Car::getCarId)
        .filter(carIdToId::containsKey)
        .map(carId -> new Car(carIdToId.get(carId), carId))
        .collect(Collectors.toList());
System.out.println(obj2Arr);
// [Car(id=2, carId=1234)]