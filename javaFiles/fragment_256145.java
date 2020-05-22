public class MyClass extends Structure {
    public char[] buffer = new char[32];
    public MyClass(Pointer p) {
        super(p);
        read();
    }
}