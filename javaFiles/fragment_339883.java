public class ListFactory {

    public ListFactory() {
        super();
    }

    public static List newInstance(final int[] numbers) {
        return new ListFactory$1(numbers);
    }
}