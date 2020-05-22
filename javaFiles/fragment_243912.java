public class Test {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new TestModule());

        ExampleProvider exampleProvider = injector.getInstance(ExampleProvider.class);
        Example example = exampleProvider.get();

        example.tryMe();

        Example directExample = injector.getInstance(Example.class);

        directExample.tryMe();

    }
}