public class TestRect {

    private final double x;
    private final double y;
    private final double base;
    private final double height;

    private double area;
    private double perimeter;

    public TestRect(double x, double y, double base, double height) {
        this.x          = x;
        this.y          = y;
        this.base       = base;
        this.height     = height;
        this.perimeter  = 2 * (base + height);
        this.area       = base * height;
    }

    public double getPerimeter()    { return perimeter; }
    public double getArea()         { return area; }
    @Override
    public String toString()        { return "(" + x + ", " + y + ", " + base + ", " + height + ")"; }

    public static void main(String[] args) {

        double x = 0, y = 0, base = 0, height = 0;

        if (args.length == 4) {
                x       = readDoubleFromString(args[0]);
                y       = readDoubleFromString(args[1]);
                base    = readDoubleFromString(args[2]);
                height  = readDoubleFromString(args[3]);
        }

        TestRect test = new TestRect(x, y, base, height);

        System.out.println(test.toString());
        System.out.println("Area = " + test.getArea());
        System.out.println("Perimeter = " + test.getPerimeter());
    }

    private static double readDoubleFromString(String d) {
        double n = 0;
        try {
            n = Double.parseDouble(d);
        } catch (NumberFormatException e) {
            System.out.println(d + " is not a valid double. 0.0 is used instead!");
        }
        return n;
    }
}