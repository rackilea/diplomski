import your.package.CarC;
import your.package.CarD;
public class NewClass
{
    public static void tryThis(CarC c, CarD d) {
        int n1 = c.odometer;  // legal
        int n2 = d.odometer;  // illegal
    }
}