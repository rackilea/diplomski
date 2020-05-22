wsimport -d generated http://example.org/stock?wsdl

public User getUser(User user) {
        try {
            template = new WebServiceTemplate(marshaller);
            JAXBElement<?> response =  (JAXBElement<?>)template.marshalSendAndReceive("http://localhost:8080/HERSvc/InsService", 
            new ObjectFactory().createGetUser(user),
                    new WebServiceMessageCallback() {
                        public void doWithMessage(WebServiceMessage message) {
                            try {
                                SoapMessage soapMessage = (SoapMessage)message;
                                SoapHeader header = soapMessage.getSoapHeader();
                                StringSource headerSource = new StringSource("<version>1.0</version>");
                                        Transformer transformer = TransformerFactory.newInstance().newTransformer();
                                        transformer.transform(headerSource, header.getResult());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                }) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        GetUserResponse responseObject = (GetUserResponse)response.getValue();
    User user = responseObject.getReturn();
    }