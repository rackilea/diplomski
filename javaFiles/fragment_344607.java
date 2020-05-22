public class OuterClass {

    private void printMessage(String message) {
        System.out.println(message);
    }

}

class InnerClass {

    private void sayHello(OuterClass outer) {
        outer.printMessage("Hello world!"); // ERROR: The method printMessage(String) from the type OuterClass is not visible
    }

}