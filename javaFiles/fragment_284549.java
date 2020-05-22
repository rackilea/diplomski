public class AllModes {
    private final Supplier<Stream<Car>> cars;
    private final Supplier<Stream<Boat>> boats;

    public AllModes(Optional<Car> car, Optional<Boat> boat) {
        // Assuming Java 8, when Optional did not have a stream() method yet
        this.cars = () -> car.map(Stream::of).orElse(Stream.empty());
        this.boats = () -> boat.map(Stream::of).orElse(Stream.empty());
    }

    public AllModes(List<Car> cars, List<Boat> boats) {
        this.cars = cars::stream;
        this.boats = boats::stream;
    }

    public Stream<Car> getCars() {
        return cars.get();
    }

    public Stream<Boat> getBoats() {
        return boats.get();
    }
}