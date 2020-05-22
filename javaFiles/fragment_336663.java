import java.util.function.BiConsumer;

public class MyClass<T> {

    private BiConsumer<MyClass<T>, T> lambda;

    public MyClass(BiConsumer<MyClass<T>, T> lambda) {
        this.lambda = lambda;
    }

    private static void doSomethingOutside() {
        // TODO Auto-generated method stub

    }

    private void doSomething(T obj) {
        // TODO Auto-generated method stub

    }

    public void go(T o) {
        lambda.accept(this, o);
    }

    public static void main(String[] args) {
        MyClass<String> myObj = new MyClass<>((me, obj) -> {
            doSomethingOutside();
            me.doSomething(obj);
        });

        myObj.go("Hello World!");
    }
}