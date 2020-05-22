File infile = new File("D:\\Cust.xml");
  DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
  // namespaces - DocumentBuilderFactory is *not* namespace aware by default
  dbFactory.setNamespaceAware(true);
  DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
  Document doc = dBuilder.parse(infile);
  doc.getDocumentElement().normalize();

  System.out.println("root of xml file " +
                     doc.getDocumentElement().getNodeName());
  System.out.println("==========================");

  NodeList list = doc.getElementsByTagNameNS(
        "http://abc.com/elements", "CustomerDetails");
  System.out.println(list.getLength());
  for(int i = 0; i < list.getLength(); i++) {
    Element custDetails = (Element)list.item(i);
    Element id = custDetails.getElementsByTagNameNS(
        "http://abc.com/elements", "CustomerId").item(0);
    System.out.println("Customer ID: " + id.getTextContent());
    Element name = custDetails.getElementsByTagNameNS(
        "http://abc.com/elements", "CustomerName").item(0);
    System.out.println("Customer Name: " + name.getTextContent());
  }