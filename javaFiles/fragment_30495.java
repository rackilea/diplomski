public class Main {

    public static double delta(double d1, double d2) {
        return Math.abs(d1- d2) / Math.max(Math.abs(d1), Math.abs(d2));
    }

    public static void main(String[] args) {
        System.out.println(delta(0.1*0.1, 0.01));
        System.out.println(delta(1.0000000001 - 1.0, 0.0000000001));
    }

}