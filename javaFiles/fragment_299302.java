public class One {
    public static void main(String[] args) {
        int someValue = 10;
        for (int i = 0; i < 10000000; i++) {
            String stringValue = Integer.toString(someValue);
        }
    }
}