class Protector {
    private String secretMessage = "abc";

    void pass(Consumer<? super String> consumer) {
        consumer.accept( secretMessage );
    }
}