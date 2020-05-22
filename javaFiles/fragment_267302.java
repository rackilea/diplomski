public static Map<String, List<Car>> componentsInCar(List<Car> cars) {
    return cars.stream()
               .flatMap(car -> car.getComponents().stream().distinct().map(comp -> new SimpleEntry<>(comp, car)))
               .collect(Collectors.groupingBy(
                   Entry::getKey,
                   Collectors.mapping(Entry::getValue, Collectors.toList())
               ));
}