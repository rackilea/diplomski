public void marshalWithSoapActionHeader(MyObject o) {

    webServiceTemplate.marshalSendAndReceive(o, new WebServiceMessageCallback() {

        public void doWithMessage(WebServiceMessage message) {
            try {
                SoapMessage soapMessage = (SoapMessage)message;
                SoapHeader header = soapMessage.getSoapHeader();
                StringSource headerSource = new StringSource("<credentials xmlns=\"http://example.com/auth\">\n +
                        <username>"+username+"</username>\n +
                        <password>"+password"+</password>\n +
                        </credentials>");
                Transformer transformer = TransformerFactory.newInstance().newTransformer();
                transformer.transform(headerSource, header.getResult());
            } catch (Exception e) {
                // exception handling
            }
        }
    });
}