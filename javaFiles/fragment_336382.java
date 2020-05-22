public class Foo {

    private static FooStrategy strategy = FooStrategyFactory.createStrategy();

    public static void a() {
        strategy.doA();
    }
}

interface FooStrategy {
    void doA();
}