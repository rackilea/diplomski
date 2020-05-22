public interface Doable {
    public void doSomething();
}

public interface NotDoable {

}

public class DoJump implements Doable, NotDoable {
    @Override
    public void doSomething() {
        System.out.println("hi");
    }

    public NotDoable meAsNotDoable() {
        return this;
    }

    public static void main(String[] args) {
        DoJump object = new DoJump();

        // This call is possible, no errors
        object.doSomething();

        NotDoable hidden = object.meAsNotDoable();

        // Not possible, compile error, the true type is hidden!
        hidden.doSomething();
    }
}