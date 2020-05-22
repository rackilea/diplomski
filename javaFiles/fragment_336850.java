public class A {
    public A(String fileName) {
        this(new File(fileName), true);
    }

    public A(File file) {
        this(file, true);
    }

    public A(File file, boolean doSomething) {
        // Code ...
    }
}