public class Main {

    public static void main(String[] args) {
        Foo<MyClass> a = new Foo<>(new MyClass());
        Foo<MyOtherClass> b = new Foo<>(new MyOtherClass());
        a.fooAction();
        b.fooAction();
    }
}