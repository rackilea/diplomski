public class Main {

    private static Object method() {
        return false ? false : false ? false : null;
    }

    public static void main(String[] args) {
        System.out.println(method());
    }
}