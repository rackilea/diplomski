public class MyBridge extends Bridge
{
private final Bridge delegate;

protected MyBridge(final JAXBContextImpl context, final Bridge delegate)
{
    super(context);
    this.delegate = delegate;
}

// an example marshal call. There are many more...
public void marshal(final Marshaller m, final Object object, final ContentHandler contentHandler)
        throws JAXBException
{
    m.setProperty("com.sun.xml.bind.namespacePrefixMapper", namespaceMapper);
    delegate.marshal(m, object, contentHandler);
}