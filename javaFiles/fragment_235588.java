public abstract class Canine extends Animal {
    public Canine(int age) {
        super(age); // pass the age parameter up to Animal
    }
    ...
}

public class Dog extends Canine implements Pet {
    private final String name;
    public Dog(String name,int age) {
       super(age); // call the age constructor
       this.name=name;
    }
    public String getName() { return name; }
    ... rest of class ...
}