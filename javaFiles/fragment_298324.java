public class ClassFactory {
    public static MyInterface getClass(boolean type) {
        if (x) {
            return new Class1();
        }
        else {
            return new Class2();
        }
    }
}