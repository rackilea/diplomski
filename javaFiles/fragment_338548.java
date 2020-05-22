DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = dbf.newDocumentBuilder();
// create doc
Document doc = docBuilder.newDocument();
DOMImplementation domImpl = doc.getImplementation();
DocumentType doctype = domImpl.createDocumentType("web-app",
    "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN",
    "http://java.sun.com/dtd/web-app_2_3.dtd");
doc.appendChild(doctype);
doc.appendChild(doc.createElement("web-app"));
// emit
System.out.println(((DOMImplementationLS) domImpl).createLSSerializer()
    .writeToString(doc));