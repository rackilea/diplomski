import (thePackage).CarTest.Audi;
import (thePackage).CarTest.Kia;

public class Main {
    public static void main(String[] args)  {

        Driver d = new Driver();
        d.driver(new Kia());
        d.driver(new Audi());
    }
}