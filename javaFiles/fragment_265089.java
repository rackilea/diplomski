...
@Override
public void process(Exchange exchange) throws Exception {
  System.out.println("In ........");

  try {
    File file = new File("soapbody.xml"); // generic body in separate XML file for every time 
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(file);
    String body = doc.toString();
    exchange.getIn().setBody(body );

  }
  catch (Exception e) {
    e.printStackTrace();
  }
  System.out.println("in process method");
  System.out.println(exchange.getExchangeId() + " : " + exchange.getFromRouteId() + " : " + exchange.isFailed());
}
...