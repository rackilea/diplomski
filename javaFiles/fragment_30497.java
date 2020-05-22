void write(Node e, StringWriter w) {
    if (e.getNodeType() == Node.ELEMENT_NODE) {
        w.write("<"+e.getNodeName());
        if (e.hasAttributes()) {
            NamedNodeMap attrs = e.getAttributes();
            for (int i = 0; i < attrs.getLength(); i++) {
                w.write(" "+attrs.item(i).getNodeName()+"=\""+
                       attrs.item(i).getNodeValue()+"\"");              
            }
        }
        w.write(">");

        if (e.hasChildNodes()) {
            NodeList children = e.getChildNodes();
            for (int i = 0; i < children.getLength(); i++) {
                write(children.item(i), w);
            }

        }
        w.write("</"+e.getNodeName()+">");
    }
    if (e.getNodeType() == Node.TEXT_NODE) {
        w.write(e.getTextContent());
    }
}