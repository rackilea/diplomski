abstract class CarTest 
{
abstract void start();
abstract void accelerate();
abstract void brakes();

static class Kia extends CarTest
{
    Kia() {
    }

    void start()
    {
        System.out.println("Kia started");
    }   
    void accelerate()
    {
        System.out.println("Kia accelerate");
    }
    void brakes()
    {
        System.out.println("kia stops");
    }
}

static class Audi extends CarTest
{
    Audi() {
    }

    void start()
    {
        System.out.println("Audi started");
    }   
    void accelerate()
    {
        System.out.println("Audi accelerate");
    }
    void brakes()
    {
        System.out.println("Audi stops");
    }
 }
}