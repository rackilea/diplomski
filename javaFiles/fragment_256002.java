for (int i = 0; i < list.getLength(); i++) {
    Node node = list.item(i);
    javax.xml.transform.Source src = new DOMSource(node);
    java.io.StringWriter writer = new StringWriter();
    javax.xml.transform.Result result = new   
    javax.xml.transform.stream.StreamResult(writer);
    xform.setOutputProperty(
    javax.xml.transform.OutputKeys.OMIT_XML_DECLARATION, "yes");
    xform.transform(src, result);
    System.out.println(writer.toString());
}