Map<String, List<Part>> map = new HashMap<>();
for(Car car: cars) {
    for(Engine engine: car.getEngines()) {
        map.computeIfAbsent(engine.getModel(), key -> new ArrayList<>())
           .addAll(engine.getParts());
    }
}