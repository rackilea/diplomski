public class Test {

    private static boolean isCorrupted() {
        return "haha".startsWith("get");
    }

    public static void main(String[] args) throws Exception {
        String get = "get";
        Field value = String.class.getDeclaredField("value");
        value.setAccessible(true);
        value.set(get, new char[]{});
        System.out.println(isCorrupted()); // prints true
    }

}