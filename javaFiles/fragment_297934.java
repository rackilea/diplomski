public interface MyInterface3 {
    public String someInterfaceMethod();
}

public class MyImplementation2 {

    public static boolean isA(MyInterface3 subject) {
         return subject.someInterfaceMethod().equals("A");
    }

    public static boolean isB(MyInterface3 subject) {
         return subject.someInterfaceMethod().equals("B");
    }
}