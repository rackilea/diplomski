public class Test {
    public static void main(String[] args) {
        try {
            throw new RuntimeException("Bang");
        } catch (Exception e) {
            System.out.println("I caught: " + e);
        }
    }
}