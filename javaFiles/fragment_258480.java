public class Bike implements Vehicle{

    //This is the one and only instance of "Bike" in our whole programm.
    //Whenever you need a Bike, you will have to use this one.
    private static Bike bike = new Bike();

    private Bike(){
        //as you see the constructor is private. Only the Class Bike can instantiate a Bike
        //this is the idea of the Singleton-Pattern. There is one and only one instance of something
        //but this instance can be accessed from (all) other classes.
    }

    public static Bike getInstance(){
        //whoever needs the bike has to call getInstance()
        //We will then pass a reference to the private static bike to whoever needs it, since they cannot 
        //create their own bike via new Bike()
        return bike;
    }

    protected static void drive(){
        System.out.println("Bruuum Bruuuum");
    }

    //Overriding some of the Vehicle-methods here.....

    //whoever holds a reference to our bike can now call this method and of course all the methods
    //provided by our Interface

}