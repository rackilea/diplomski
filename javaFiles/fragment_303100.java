// Load document
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = factory.newDocumentBuilder();
Document doc = builder.parse( new FileInputStream( "/tmp/xml" ) );

// Create XPath expression
XPathFactory xPathfactory = XPathFactory.newInstance();
XPath xpath = xPathfactory.newXPath();
XPathExpression expr = xpath.compile( "//server01/department" );

// Find nodes 'department' under node 'server01'
NodeList node = (NodeList) expr.evaluate( doc, XPathConstants.NODESET );

// Extract departments
for( int k = 0 ; k < node.getLength() ; k++ ) {
    Node childNode = node.item( k );
    // Check if current node is a department node
    if( "department".equals( childNode.getNodeName() ) ) {
        System.out.println( "[" + k + "] " + childNode.getNodeName() + ": " + childNode.getTextContent().trim() );
    }
}