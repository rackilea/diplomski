public class Abstract {
public static void main(String args[]){

    Car car1 = new Car();   

}
abstract class MotorVehicle
{

    int fuel;


    int getFuel()
    {
         return this.fuel;
    }


    abstract void run();


}

static class Car
{
    void run()
    {

        System.out.print("Wrroooooooom");
    }


}
}