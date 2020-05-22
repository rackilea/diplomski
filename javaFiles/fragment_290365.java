public class AppConstants {
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int TEN = 10;
    public static final List<String> NAMES = Collections.unmodifiableList(Arrays.asList("Luiggi", "Andy"));
}

public class ClientTest {
    public static void main(String[] args) {
        System.out.println(AppConstants.ONE);
        System.out.println(AppConstants.TWO);
        System.out.println(AppConstants.TEN);
        System.out.println(Foo.NAMES);
    }
}