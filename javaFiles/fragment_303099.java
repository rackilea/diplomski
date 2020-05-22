// Load document
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse( new FileInputStream( "/tmp/xml" ) );

    // Create XPath expression
    XPathFactory xPathfactory = XPathFactory.newInstance();
    XPath xpath = xPathfactory.newXPath();
    XPathExpression expr = xpath.compile( "//server01" );

    // Find node 'server01'
    Node node = (Node) expr.evaluate( doc, XPathConstants.NODE );
    if( node == null ) {
        System.out.println( "Node not found" );
        System.exit( 0 );
    }

    // Extract departments
    Element server01 = (Element) node;
    for( int k = 0 ; k < server01.getChildNodes().getLength() ; k++ ) {
        Node childNode = server01.getChildNodes().item( k );
        // Check if current node is a department node
        if( "department".equals( childNode.getNodeName() ) ) {
            System.out.println( childNode.getNodeName() + ": " + childNode.getTextContent().trim() );
        }
    }