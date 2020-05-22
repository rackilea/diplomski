public class MyClass {
    public static void main(String[] args) {
        for (int i = 1; true; i++) {
            int square = i * i;
            if (square > 200) {
                return;
            }
            if (square > 15) {
                System.out.println(square);
            }
        }
    }
}