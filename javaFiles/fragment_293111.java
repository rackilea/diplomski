public class SpecializedServiceBuilder<U> extends ServiceBuilder<SomeObject, U> {

    ServiceBuilder withSomeObjectFunction(Function<SomeObject, U> mapper) {
        this.supplier = new DummySupplier();
        this.mapper = mapper;
        return this;
    }
}