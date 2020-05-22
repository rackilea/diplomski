public class Entity {
    public void sayHi() {
        System.out.println("Hi there!");
    }
}
public class Person extends Entity {
    @Override
    public void sayHi() {
        super.sayHi();
        System.out.println("I’m a person!");
    }
}