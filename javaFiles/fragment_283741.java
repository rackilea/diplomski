public class Circle 
{
    double x; // x-coordinate of centre
    double y; // y-coordinate of centre
    double r; // radius

    public static void main(String[] args)
    {   
        Circle c1 = new Circle();
        c1.x = 1;
        c1.y= 2;
        c1.r= 4;

        Circle c2 = new Circle ();
        c2.x = -2;
        c2.y=0;
        c2.r=2;

        System.out.println("distance " + Math.sqrt((c2.x-c1.x)*(c2.x-c1.x) + (c2.y-c1.y)*(c2.y-c1.y)) );
    }
}