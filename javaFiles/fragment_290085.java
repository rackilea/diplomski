@Override
    public void doWithMessage(WebServiceMessage webServiceMessage) throws IOException, TransformerException {

    SoapHeader soapHeader = ((SoapMessage)webServiceMessage).getSoapHeader();

    try {
        JAXBContext context = JAXBContext.newInstance( MessageHeader.class, Security.class );

        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal( header, soapHeader.getResult() );
        marshaller.marshal( security, soapHeader.getResult() );

    } catch (JAXBException e) {
        e.printStackTrace();
    }
}