public DualProtocolSaajSoapMessageFactory() {
    super();

    try {
        messageFactory11 = MessageFactory.newInstance(SOAPConstants.SOAP_1_1_PROTOCOL);
        messageFactory12 = MessageFactory.newInstance(SOAPConstants.SOAP_1_2_PROTOCOL);
    } catch (Exception ex) {
        throw new SoapMessageCreationException("Could not create SAAJ MessageFactory: " + ex.getMessage(), ex);
    }
}