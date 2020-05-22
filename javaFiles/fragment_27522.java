public class ConsumerTestClass {
    public ConsumerTestClass(Consumer<String> consumer) {
        consumer.accept("Test");
    }

    public static void printString(String text) {
        System.out.println(text);

    }

    public static void main(String[] args) {
        new ConsumerTestClass(ConsumerTestClass::printString);
    }
}