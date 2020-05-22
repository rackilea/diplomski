public Interface Automobile{
    //define an interface that describes the methods common to your two classes

    public void drive();
}

//this is one of your two classes 
public class Sedan implements Automobile{
    public void drive(){
        //Sedan-specific implementation here
    }
}

//here's the other one. It's similar in that it has a drive method, but different
//in that it's implementation for drive() is different, and there might be 
//other stuff in this class that is different from Sedan. However, it still is-an
//Automoblie
public class RaceCar implements Automobile{
    public void drive(){
        //RaceCar-specific implementation here
    }
}

public class YourApplication{

    //some method that accepts either one of the two classes you 
    //described as being "similar"
    public void someMethod(Automobile automobile){
        //you could pass in either a Sedan or a RaceCar, and
        //the corresponding drive() method would get called
        automobile.drive(); 
    }

    public static void main(String args[]){
        Automobile car1 = new Sedan();
        Automobile car2 = new RaceCar();

        someMethod(car1);
        //call the same method, but with car2!
        someMethod(car2);
    }
}