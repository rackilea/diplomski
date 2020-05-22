public class BaseBuilder<T extends BaseBuilder<T>> {
    @SuppressWarnings("unchecked")
    public T foo() {
        return (T)this;
    }
}

public class DerivedBuilder extends BaseBuilder<DerivedBuilder> {
    public DerivedBuilder bar() {
        return this;
    }
}