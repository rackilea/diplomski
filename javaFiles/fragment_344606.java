public class OuterClass {

    private void printMessage(String message) {
        System.out.println(message);
    }

    private static class InnerClass {

        private void sayHello(OuterClass outer) {
            outer.printMessage("Hello world!"); // allowed
        }

    }
}