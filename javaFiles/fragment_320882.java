//xmlString has the xml message to send to the web service  
    StreamSource xmlMsg = new StreamSource(new StringReader(xmlString));   
    //Create URL of web service. Place your URL for WSDL
    URL wsdlURL = new URL("http://10.5.2.10:8080/path/service?wsdl");  
    QName serviceName = new QName("http://example.com",  "TrivialWebService");  
    Service s = Service.create(wsdlURL, serviceName);  
    QName portName = new QName("http://example.com", "TrivialWebServicePort");  
    //Service.Mode.MESSAGE works on SOAP msg (as opposed to Service.Mode.PAYLOAD)
    Dispatch<Source> dispatch = createDispatch(portName,  
                                                      Source.class,  
                                                      Service.Mode.MESSAGE);  
    //Send request
    Source reply = dispatch.invoke(xmlMsg);  
    DOMResult domResponse = new DOMResult();
    Transformer trans = TransformerFactory.newInstance().newTransformer();
    trans.transform(reply, domResponse); 
    //Now use DOM APIs