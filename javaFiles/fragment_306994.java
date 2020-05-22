public abstract class BaseAnimal implements Animal {
    public void doCommonStuff() {
        //any common logic that can be shared between concrete  implementation goes here
    }
}

public class Dog extends BaseAnimal implements Animal {
    @Override
    public void makeSound() {
       doCommonStuff();
       //do something specific to a dog
    }
}