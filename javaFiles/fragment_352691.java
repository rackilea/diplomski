XPathExpression expr = xpath.compile( "//venue" );

    Object result = expr.evaluate( document, XPathConstants.NODESET );
    NodeList nodes = (NodeList)result;
    for( int i = 0; i < nodes.getLength(); i++ ) {
        Node node = nodes.item( i );
        NodeList venueChildNodes = node.getChildNodes();

        String id = venueChildNodes.item( 1 ).getChildNodes().item( 0 ).getNodeValue();
        System.out.println( "id: " + id );

        String name = venueChildNodes.item( 3 ).getChildNodes().item( 0 ).getNodeValue();
        System.out.println( "name: " + name );

        String address = venueChildNodes.item( 7 ).getChildNodes().item( 0 ).getNodeValue();
        System.out.println( "address: " + address );
    }