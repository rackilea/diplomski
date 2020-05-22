public class SilentSpring {
    /** Expected output: args[0] 0 */
    public static void main(String[] args) {
        try {
            long i = System.currentTimeMillis() % 3;
            System.out.print(args[0] + " ");
            System.out.println(0 / i);
        } catch (Exception e) {}
    }
}