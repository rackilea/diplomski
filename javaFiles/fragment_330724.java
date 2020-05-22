public class Test {

    public static Integer min(Iterator<Integer> it) {
        if (it.hasNext()) {
            return Math.min(it.next(), min(it));
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(min(Arrays.asList(2, 3, 1, 4, 5).iterator()));
    }
}