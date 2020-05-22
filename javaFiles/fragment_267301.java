public static Map<String, List<Car>> componentsInCar(List<Car> cars) {
    Map<String, List<Car>> result = new HashMap<>();
    cars.forEach(car -> {
        car.getComponents().forEach(comp -> {
            result.computeIfAbsent(comp, ignoreMe -> new ArrayList<>()).add(car);
        });
    });

    return result;
}