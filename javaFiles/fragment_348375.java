public static String editTagXML(String tag,
        Map<String, String> newAttributes,
        Collection<String> removeAttributes)
        throws SAXException, IOException,
        ParserConfigurationException, TransformerConfigurationException,
        TransformerException {
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
            .parse(new InputSource(new StringReader(tag)));
    Element root = doc.getDocumentElement();
    NamedNodeMap attrs = root.getAttributes();
    for (String removeAttr : removeAttributes) {
        attrs.removeNamedItem(removeAttr);
    }
    for (Map.Entry<String, String> addAttr : newAttributes.entrySet()) {
        final Attr attr = doc.createAttribute(addAttr.getKey());
        attr.setValue(addAttr.getValue());
        attrs.setNamedItem(attr);
    }
    StringWriter result = new StringWriter();
    final Transformer transformer = TransformerFactory.newInstance()
            .newTransformer();
    transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    transformer.transform(new DOMSource(doc), new StreamResult(result));
    return result.toString();
}

public static void main(String[] args) throws Exception {
    long start = System.nanoTime();
    String tag = "<input type=\"submit\" class=\"cssSubmit\"/>";
    String edited = editTagXML(tag, new HashMap<String, String>() {{
        put("class", "cssSubmit disable");
        put("disabled", "disabled");
    }}, new ArrayList<>());
    long time = System.nanoTime() - start;
    System.out.println(edited);
    System.out.println("Time: " + time + " ns");
    start = System.nanoTime();
    tag = "<input type=\"submit\" class=\"cssSubmit\"/>";
    editTagXML(tag, new HashMap<String, String>() {{
        put("class", "cssSubmit disable");
        put("disabled", "disabled");
    }}, new ArrayList<>());
    time = System.nanoTime() - start;
    System.out.println("Time2: " + time + " ns");
}