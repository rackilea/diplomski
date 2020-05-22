private Node importNodeFromString( String fragment, Document ownerDokument ) {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    dbf.setNamespaceAware( true );

    Node node;
    try {
        node = dbf.newDocumentBuilder().parse( new InputSource( new StringReader( fragment ) ) ).getDocumentElement();
    }
    catch ( SAXException | IOException | ParserConfigurationException e )                {
        throw new RuntimeException( e );
    }

    node = ownerDokument.importNode( node, true );
    return node;
}