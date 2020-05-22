public class CarPriceComparator extends Comparator<Car> {
    @Override
    public int compareTo(Car first, Car second) {
        return Integer.compare(first.getPrice(), second.getPrice());
    }
}