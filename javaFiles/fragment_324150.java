public abstract class Base {
    public abstract void method() throws IOException;
}

public class A extends Base {
    public void method() throws IOException {
        //
    }
}

public class B extends Base {
    public void method() {  // Doesn't throw!!!
        //
    }
}