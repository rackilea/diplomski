private static Node getMatXML(Document doc, String option_id, String type_id, String rows, String cols, String dt, String data) {
    Element elem = doc.createElement(option_id);
    elem.setAttribute("type_id", type_id);
    elem.appendChild(getMatXMLElement(doc,"rows", rows));
    elem.appendChild(getMatXMLElement(doc, "cols", cols));
    elem.appendChild(getMatXMLElement(doc, "dt", dt));
    elem.appendChild(getMatXMLElement(doc, "data", data));
    return elem;
}

private static Node getMatXMLElement(Document doc, String name, String value) {
    Element node = doc.createElement(name);
    node.appendChild(doc.createTextNode(value));
    return node;
}