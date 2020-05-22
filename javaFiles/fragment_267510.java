import java.util.Comparator;

public class TestComparator {
    static class Comparator1 implements Comparator<Integer> {
        @Override
        public int compare(final Integer o1, final Integer o2) {
            return Integer.compare(o1, o2);
        }
    }

    static class Comparator2 implements Comparator<Integer> {
        @Override
        public int compare(final Integer o1, final Integer o2) {
            return Integer.compare(o1, o2);
        }
    }

    public static void main(final String[] args) {
        final Comparator1 c1 = new Comparator1();
        final Comparator1 c11 = new Comparator1();
        final Comparator2 c2 = new Comparator2();

        System.out.println(c1.equals(c1)); // true
        System.out.println(c1.equals(c11)); // false
        System.out.println(c1.equals(c2)); // false
    }
}