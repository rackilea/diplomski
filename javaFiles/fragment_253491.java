class SomeClass {
    private final ConfigRetriever retriever;
    public SomeClass(ConfigRetriever retriever) {
        this.retriever = retriever;
    }
    public void someMethod() {
        // use this.retriever here
    }
}