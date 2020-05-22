@Override
public void process(Exchange exchange) throws Exception {
    CxfPayload<SoapHeader> request = exchange.getIn().getBody(CxfPayload.class);

    XmlConverter converter = new XmlConverter();
    String xmlInRequest = converter.toString(request.getBody().get(0).cloneNode(true), exchange);

    xmlInRequest = xmlInRequest.replace(" xmlns=\"<wsdl-namespace-url>\"", "");
    xmlInRequest = xmlInRequest.replace(" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"", "");
    xmlInRequest = xmlInRequest.replace(" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\"", "");
    xmlInRequest = xmlInRequest.replace(" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "");
    xmlInRequest = xmlInRequest.replace("<?xml version=\"1.0\" encoding=\"utf-8\"?>", "");

    JAXBContext jaxbContext = JAXBContext.newInstance("com.rmg.globalrates.adapter.models");
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    StreamSource streamSource = new StreamSource(new StringReader(xmlInRequest));
    ObjectInfo objectInfo  = (ObjectInfo) unmarshaller.unmarshal(streamSource);
    System.out.println("----------------------------ObjectInfo-----------------------" + objectInfo.toString());
}