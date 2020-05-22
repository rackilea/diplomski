public class Square extends Rectangle
{
    Square(double width) 
    {
        super(width, length);
    }

    double getArea() 
    {
        double area = width * width;
        return area;
    }  



    void show() 
    {
        System.out.println("Square's width is: " + width) ;
        System.out.println("Square's area is: " + getArea());
    }

}