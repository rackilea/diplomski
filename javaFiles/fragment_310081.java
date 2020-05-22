public class Test {
    public static void main(String[] args) {
        int[] x = { 0, 1, 2, 3, 4 };
        int j = 3;
        try {
            x[j + 1] = x[j-- + 10];
        } catch (Exception e) {
            System.out.println("Caught exception");
        }

        System.out.println(j); // Prints 2
    }
}