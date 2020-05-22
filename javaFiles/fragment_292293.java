public class Foo<E extends Number> {

    public static interface NumberFactory<T extends Number> {
        T createByDoubleValue(double value);
    }

    private final NumberFactory<E> factory;

    public Foo(NumberFactory<E> factory) {
        this.factory = factory;
    }

    ...
    public void someMethod() {
      ... // some computation
      // Because every Number has a doubleValue(),
      // I would like to give newInstance a double value, how?
      E instance = factory.createByDoubleValue(1.5);
    }
  }