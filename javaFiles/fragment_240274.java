public interface FloorWax { }

public interface DesertTopping { }

public class Shimmer implements implements FloorWax, DessertTopping { }

public class ShimmerChild extends Shimmer {}

public static void main(String[] args) {
    // throws ArrayOutOfBoundsException
    System.out.println(new ShimmerChild().getClass().getInterfaces()[0]);
}