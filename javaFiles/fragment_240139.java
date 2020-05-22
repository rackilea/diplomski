public class Test implements DoubleSupplier {
    private double a;
    public Test(double a) { this.a = a; }
    public double getAsDouble() { return 10 * a; }

    public static double test(DoubleSupplier ds) { 
        return ds.getAsDouble();
    }
    public static void main(String[] args) {
        double a = test(new Test(5));
    }
}