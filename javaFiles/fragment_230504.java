public class TelemeterTester<E extends Comparable<E>> implements Telemeter<E> {
    private TelemeterTester() {
    }

    public int compare(E o1, E o2) {
        return o1.compareTo(o2);
    }

    @Override
    public double distance(E e1, E e2) {
        return 0;
    }
}