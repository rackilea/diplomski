import java.util.*;

// Class name should start uppercase
public class Egypt
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Pyramid luxor; // start with lowercase
        double width, height; // start with lowercase

        // Get input values
        System.out.println("Enter Luxor's width:");
        width = in.nextDouble();
        System.out.println("Enter Luxor's height:");
        height = in.nextDouble();

        // Initialize variable
        luxor = new Pyramid(width, height);

        System.out.println("Luxor has volume of " + luxor.getVolume());
        System.out.println("Luxor has a Surface Area of " + luxor.getSurfaceArea());
    }
}

// This class describes pyramids with a square base.
public class Pyramid
{
    private double height;
    private double width;

    public Pyramid(double width, double height)
    {
        this.height = height; this.width = width;
    }

    public double getVolume()
    {
        return height * width * width / 3;
    }


    public double getSurfaceArea()
    {
        double sideLength = Math.sqrt(height * height
                + width * width/ 4);
        return 2 * width * sideLength;
    }
}