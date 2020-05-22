package CallBefore;

public class Main {

    public static void main(String[] args) {

    ExampleInterface proxy = ExampleProxy.newInstance(new Example());
    proxy.function1();
    proxy.function2();
    proxy.otherFunction();
    proxy.refresh();
    }
}