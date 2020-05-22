public class MyContext extends JAXBRIContext
{
/** the actual context */
private final JAXBRIContext delegate;

public MyContext(final JAXBRIContext createContext)
{
    this.delegate = createContext;
}

public Bridge createBridge(final TypeReference arg0)
{
    return new MyBridge((JAXBContextImpl) delegate, delegate.createBridge(arg0));
}