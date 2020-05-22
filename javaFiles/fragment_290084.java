public class HeaderComposingCallback implements WebServiceMessageCallback {

    private final String action;

    public HeaderComposingCallback( String action ) {
        this.action = action;
    }

    @Override
    public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {

    SoapHeader soapHeader = ((SoapMessage)webServiceMessage).getSoapHeader();

    try {
        JAXBContext context = JAXBContext.newInstance( MessageHeader.class, Security.class );

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document securityDocument = builder.newDocument();
        Document headerDocument = builder.newDocument();

        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal( HeaderFactory.getHeader( action ), headerDocument );
        marshaller.marshal( SecurityFactory.getSecurity(), securityDocument );

        Transformer t = TransformerFactory.newInstance().newTransformer();

        DOMSource headerSource = new DOMSource( headerDocument );
        DOMSource securitySource = new DOMSource( securityDocument );

        t.transform( headerSource, soapHeader.getResult() );
        t.transform( securitySource, soapHeader.getResult() );

    } catch (JAXBException | ParserConfigurationException e) {
        e.printStackTrace();
    }
}

}