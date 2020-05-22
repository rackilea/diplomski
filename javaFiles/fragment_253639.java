public class MyCars
{
    private static Car audi = new Car()
 //                     (2)
    private Car volvo = new Car()
 //              (5)       (6)
    static
    {
        audi.setNumberOfWheels = 4;
 //                  (3)
    }
    public MyCars()
    {
         volvo.setBrand = "Volvo";
         volvo.setModel = "XC70";
 //              (7)
    }
}

MyCars myCars = new MyCars();
// (1)                (4)