public abstract class Animal1 { // If you want to have an abstract method, declare the class as abstract

    private final String animalName;
    private final int numberOfLegs; // better of using private and make it final since it's not going to change.

    public Animal1(final String name, final int legs){ //better making the input parameters final since they are not supposed to be changed
        //name = animalName; 
        //legs = numberOfLegs;//it assigned the field to an input parameter. that will take no effect on the object created.
        animalName = name;
        numberOfLegs = legs;
    }

    public String getName(){
        return animalName;
    }

    public int getLegs(){
        return numberOfLegs;
    }

    public boolean isAnimal(){ //boolean function needs a return type too!!
        return true;
    }

    public boolean isCarnivorous(){
        return true;
    }

    public abstract String getHello(); // an abstract method has same requirement as a normal method besides the abstract modifier. it will need a return type. And it ends with a semicolon

}

public class Cat1 extends Animal1{

    public Cat1(final String name){
        super(name, 4); //use super to call parent constructor
    }

    @Override
    public String getHello(){   
        return "Meow";
    }
}

public class Dog1 extends Animal1{

    public Dog1(final String name){
        super(name, 4);
    }

    @Override
    public String getHello(){
        return "Woof";
    }
}