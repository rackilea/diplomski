abstract class Car{
    public int drivenKm;
    //....

    public abstract void checkCar();
}
public class Volvo extends Car {
    public void checkCar() {
         checkWithVolvoTestSpecs1();
    }

    //you have some Volvo-specific tests implemented here 
    public void checkWithVolvoTestSpecs1(){
        //....
    }
}
public class BMW extends Car {
    public void checkCar() {
         checkWithBMWTest();
    }

    //you have some BMW-specific tests implemented here 
    public void checkWithBmWTest(){
        //....
    }
}