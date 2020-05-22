interface Example<T extends Example<T>> {
    void foo(T t);
}

public class ExampleImpl implements Example<ExampleImpl> {
    @Override
    public void foo(ExampleImpl example) {
    }
}