public class DistanceFilter implements IntPredicate {

    private final int distance;
    private int previousValue;

    public DistanceFilter(int distance) {
        this(distance, 0);
    }

    public DistanceFilter(int distance, int startValue) {
        this.distance = distance;
        this.previousValue = startValue;
    }

    @Override
    public boolean test(int value) {
        if (Math.abs(previousValue - value) > distance) {
            previousValue = value;
            return true;
        }
        return false;
    }

    // Just for simple demonstration
    public static void main(String[] args) {
        int[] ints = IntStream.of(2, 20, 18, 17, 4, 11, 13, 6, 3, 19, 4, 10, 13)
                .filter(new DistanceFilter(5))
                .toArray();

        System.out.println(Arrays.toString(ints));
    }
}