static void helloWorld(Consumer<String> consumer) {
    consumer.apply("Hello World!");
}

public static void main(String[] args) {
    helloWorld(System.out::println);
}