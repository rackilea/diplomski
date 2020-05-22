/* file Dog.java */
public static class Dog extends Animal {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}

/* file CleverDog.java */
public class CleverDog extends Dog {

    public CleverDog(String name) {
         super(name);
    }

    public void rollover() {
        System.out.println(super.getName()+" rolls over!");
    }

    public void speak() {
        System.out.println(super.getName() + " speaks!");
    }

}