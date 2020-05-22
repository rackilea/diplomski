public static XPath buildXPath() {
    XPathFactory factory = XPathFactory.newInstance();
    XPath xpath = factory.newXPath();
    xpath.setNamespaceContext(new AtomNamespaceContext());
    return xpath;
}


public class AtomNamespaceContext implements NamespaceContext {

    public String getNamespaceURI(String prefix) {
        if (prefix == null)
            throw new NullPointerException("Null prefix");
        else if ("a".equals(prefix))
            return "http://www.w3.org/2005/Atom";
        else if ("app".equals(prefix))
            return "http://www.w3.org/2007/app";
        else if ("os".equals(prefix))
            return "http://a9.com/-/spec/opensearch/1.1/";
        else if ("x".equals(prefix)) 
            return "http://www.w3.org/1999/xhtml";
        else if ("xml".equals(prefix))
            return XMLConstants.XML_NS_URI;
        return XMLConstants.NULL_NS_URI;
    }

    // This method isn't necessary for XPath processing.
    public String getPrefix(String uri) {
        throw new UnsupportedOperationException();
    }

    // This method isn't necessary for XPath processing either.
    public Iterator getPrefixes(String uri) {
        throw new UnsupportedOperationException();
    }
}