@PrepareForTest({SocketChannel.class})
@RunWith(PowerMockRunner.class)
public class TestThatUsesSocketChannelChannel
{
    replace(method(SocketChannel.class, "read", ByteBuffer.class)).with((proxy, method, args) -> 
    {
        // Line below intercepts the argument and manipulates it 
        ((ByteBuffer) args[0]).clear();
    });
    // THIS Fixes it: generate a an on-the-fly class that implements stub methods
    // for the ones that are abstract and then (and only then) pass that to Whitebox
    Class<?> concreteSocketChannelClass = new ConcreteClassGenerator().createConcreteSubClass(SocketChannel.class);
    SocketChannel socketChannel = (SocketChannel) Whitebox.newInstance(concreteSocketChannelClass);
    // Once here, ideally I can continue my test
}