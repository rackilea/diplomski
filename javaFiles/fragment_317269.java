@Data @AllArgsConstructor
class Car {
    Long id = null;
    Long carId = null;
}
List<Car> obj1Arr = Arrays.asList(new Car(1L, 123L), new Car(2L, 1234L));
List<Car> obj2Arr = Arrays.asList(new Car(0L, 1234L), new Car(0L, 12345L));

Map<Long, Long> carIdToId = obj1Arr.stream()
        .collect(Collectors.toMap(Car::getCarId, Car::getId));
// [Car(id=2, carId=1234), Car(id=0, carId=12345)]