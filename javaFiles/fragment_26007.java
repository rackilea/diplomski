private Element getHeader() throws XmlPullParserException, IOException {
    // First Parse
        XmlPullParserFactory factory = null;
        factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser xpp = factory.newPullParser();
        xpp.setInput((Reader)new StringReader(tokenID));

    // Second Parse and create a Document        
        Document doc = new Document();
        doc.parse(xpp);

    //Create Element and add Child        
        Element header = new Element().createElement("http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd", "Security");
        header.addChild(Node.ELEMENT, doc.getChild(0));
        return header;
    }