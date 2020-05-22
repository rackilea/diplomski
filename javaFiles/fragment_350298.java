public class Car implements Comparable<Car> {
    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.getPrice(), other.getPrice());
    }

    // The other stuff of the car class
}