static private Namespace NSSERVICE = Namespace.getNamespace("http://www.test.com/schemas/2005/06/messages");
static private Namespace NSSCHEMA = Namespace.getNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");

String sXMLOut = "";
Element barceloDS_requests= new Element("ServiceAddRQ",NSSERVICE);  
barceloDS_requests.setAttribute("echoToken",searchParams.getSessionID().substring(0, 12)+GenTools.getSystemDateWithTime3());
barceloDS_requests.setAttribute("version","2013/12");
barceloDS_requests.addNamespaceDeclaration(NSSCHEMA);
barceloDS_requests.setAttribute("schemaLocation", "http://www.test.com/schemas/2005/06/messages HotelValuedAvailRQ.xsd", NSSCHEMA);

// --------------
// Key change -- Create Service element in the right namespace
Element eleService=new Element("Service",NSSERVICE);
// --------------

eleService.setAttribute("type", "ServiceHotel", NSSCHEMA);
eleService.setAttribute("availToken",contractInfo[1]);
barceloDS_requests.addContent(eleService);