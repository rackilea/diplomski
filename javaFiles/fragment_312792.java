public class CustomSoapCxfInterceptor extends AbstractSoapInterceptor {

    public CustomSoapCxfInterceptor() {
        super(Phase.PRE_STREAM);
        getAfter().add(AttachmentOutInterceptor.class.getName());

    }

    @Override
    public void handleMessage(SoapMessage message) {
        try {
            message.put("disable.outputstream.optimization", Boolean.TRUE);
            XMLStreamWriter writer = StaxUtils.createXMLStreamWriter(message.getContent(OutputStream.class));

            CDataXMLStreamWriter cDataXMLStreamWriter = new CDataXMLStreamWriter(writer);
            message.setContent(XMLStreamWriter.class, cDataXMLStreamWriter);
        } catch (Exception exception) {
            DefaultLogger.error(exception);
        }
    }
}