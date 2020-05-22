public static String toXml() {

    Document document = DocumentHelper.createDocument();
    Element documentRoot = document.addElement("ResponseMessage",
            getXmlNamespace());
    documentRoot.addAttribute(QName.get("schemaLocation", "xsi", "xsi-ns"),
            "schema.xsd").addAttribute("id", "4711");

    Element header = documentRoot.addElement("Header");

    Element body = documentRoot.addElement("Body", getXmlNamespace());
    // buildProperties(body);

    body.addElement("StatusMessage", getXmlNamespace()).addText("status");

    return document.asXML();

}

private static String getXmlNamespace() {
    return "xyzzy";
}

public static void main(String[] args) throws Exception {

    System.out.println(toXml());
}