public class Quad
{
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);

        System.out.println(Math.abs(b/a - 200.0));

        if (Math.abs(b/a - 200.0) < 1.0e-4) {
            System.out.println("first one");
        }
        else {
            System.out.println("second one");
        }
    }
}