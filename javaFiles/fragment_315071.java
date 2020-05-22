public class Main {
    /** http://stackoverflow.com/q/36053971/6077352 */
    public static void main(String[] args) {
        int input = 123456789;
        while (input > 0) {
            if (input % 2 == 0) {
                System.out.println(input % 10 + " is even");
            } else {
                System.out.println(input % 10 + " is odd");
            }
            input = input / 10;
        }
    }
}