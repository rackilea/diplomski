public static <T extends ContextWrapper & IHelloServiceConnectionObserver>
    HelloServiceConnection createConnection(T value)
{
    return new HelloServiceConnection(value, value);
}

private HelloServiceConnection(ContextWrapper wrapper,
                               IHelloServiceConnectionObserver observer)
{
    this.wrapper = wrapper;
    this.observer = observer;
}