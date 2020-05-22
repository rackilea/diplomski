abstract class Base {

    Base(String s1, String s2) {
        init(s1, s2);
    }

    protected abstract void init(String s1, String s2);
}

class MyClass extends Base {

    // Forced to do this.
    MyClass() {
        super("One", "Two");
    }

    // Forced to do this.
    @Override
    protected void init(String s1, String s2) {
    }

}