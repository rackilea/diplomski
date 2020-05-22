public class Rectangle
{
    public static void main(String[] args)
    {
        Rectangle rect = new Rectangle(2,3);
        System.out.println(rect.getArea());
    }
    private static double length;
    private static double width;

    public Rectangle()
    {
        length = 1;
        width = 1;
    }

    public Rectangle(double g, double w)
    {
        length = g;
        width = w;
    }

    public double getArea()
    {
        double area;
        area = length * width;
        return area;
    }
}