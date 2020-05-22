class Foo {
   public static final Foo X = null;
   public static final Foo Y = new Foo();
}

public class Test {
    public static void main(String[] args) {
        Foo foo = Foo.X.Y;
    }
}