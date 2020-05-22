import java.util.function.Function;

class FruitConverter<T> {
    private final Function<String, T> valueOf;

    FruitConverter(Function<String, T> valueOf) {
        this.valueOf = valueOf;
    }

    // ...
}

class AppleConverter extends FruitConverter<Apple> {
    AppleConverter() {
        super(Apple::valueOf);
    }
}