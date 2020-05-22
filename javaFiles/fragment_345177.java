/* file CleverDog.java */
public class CleverDog extends Dog {

    public CleverDog(String name) {
         super(name);
    }

    public final String getName() { // final so it can't be overridden
        return super.getName();
    }

    public void rollover() {
        System.out.println(this.getName()+" rolls over!"); // no `super` keyword
    }

    public void speak() {
        System.out.println(this.getName() + " speaks!"); // no `super` keyword
    }

}