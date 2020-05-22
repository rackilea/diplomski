public class ExampleProvider implements Provider<Example> {

    @AOPExample
    public Example get() {
        System.out.println("Building...");
        return new Example();
    }
}