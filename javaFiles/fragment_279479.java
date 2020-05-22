public abstract class WrapperClientFactory<T extends BaseClient> {
    public final WrapperClient<T> create() {
        T realClient = createRealClient();
        return new WrapperClient<T>(realClient);
    }

    protected abstract T createRealClient();
}