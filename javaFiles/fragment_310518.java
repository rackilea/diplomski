public class WsdlGetSoapInterceptor extends AbstractSoapInterceptor {
    public WsdlGetSoapInterceptor() {
        super(Phase.READ);
        addBefore(WSDLGetInterceptor.class.getName());
    }

    /** {@inheritDoc} */
    @Override
    public void handleMessage(final SoapMessage message) throws Fault {
        message.setContextualProperty(WSDLGetUtils.class.getName(), MyWSDLGetUtils.Instance);
    }
}