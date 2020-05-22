public class Animal {
    private String name;
    public String getName() { return name; }
}
public class Dog {
    @Override
    public void speak() {
        System.out.println("I am " + getName());
    }
}