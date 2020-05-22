class Square
{
    private double width;
    private double height;

    public Square()
    {
        width = 6.0;
        height = 7.0;
    }

    public double getArea()
    {
        double a; // local variable -- NOT shown in the class diagram
        a = width * height;
        return a;
    }
}