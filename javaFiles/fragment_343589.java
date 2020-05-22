public class Main {
    public static void throwsException() {
        throw new UnsupportedOperationException();
    }

    public static void main(String... args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Main.class.getMethod("throwsException").invoke(null);
    }
}