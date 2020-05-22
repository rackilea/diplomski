DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document document = builder.parse(new FileInputStream("doc.xml"));//Load document from any InputSource or InputStream
//Loop through all nodes with the input tag:
NodeList nl = document.getElementsByTagName("input");
for(int i = 0; i < nl.getLength(); i++){
    Node n = nl.item(i);
    if(n.getNodeType() != Node.ELEMENT_NODE)
        continue;
    Element e = (Element)n;
    Node previous = e;
    //Loop through all nodes before the input element:
    while((previous = previous.getPreviousSibling()) != null){
        if(previous.getNodeType() == Node.TEXT_NODE && previous.getTextContent().replaceAll("\\s+", "").length() > 0){
            System.out.println(previous.getTextContent().trim()); //Remove whitepsace from beginning and end of the text.
            break; //Break after finding the first text element of appropriate length.
        }
    }
}