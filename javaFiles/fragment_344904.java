abstract class BarkingStrategy {
    public abstract void doBark(Dog dog);
}

class TypicalBarkingStrategy extends BarkingStrategy {
    public void doBark(Dog dog) { System.out.println(dog.getName() + " says 'woof!'"); }
}

class AggressiveBarkingStrategy extends BarkingStrategy {
    public void doBark(Dog dog) { System.out.println(dog.getName() + " says 'Rrrruff!'"); }
}

class Dog {
    // notice this is static - that means it belongs to the class itself, not 
    // any particular instance of it - similar to prototype
    static BarkingStrategy bark = new TypicalBarkingStrategy();
    String name;
    Dog(String name) { this.name = name; }
    String getName() { return name; }
    void bark() { bark.doBark(this); }
}