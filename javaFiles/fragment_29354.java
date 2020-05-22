public class SynchronizedItemReader<T> implements ItemReader<T>
{
    private ItemReader<T> delegate;
    public void setDelegate(ItemReader<T> delegate) {this.delegate = delegate};

    public synchronized T read() {
        return delegate.read();
    }
}