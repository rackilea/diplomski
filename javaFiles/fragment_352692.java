XPathExpression expr = xpath.compile( "//venue" );

    Object result = expr.evaluate( document, XPathConstants.NODESET );
    NodeList nodes = (NodeList)result;
    for( int i = 0; i < nodes.getLength(); i++ ) {
        Node node = nodes.item( i );
        NodeList venueChildNodes = node.getChildNodes();

        String address = null;
        String name = null;

        for( int j = 0; j < venueChildNodes.getLength(); j++ ) {
            Node item = venueChildNodes.item( j );
            String nodeName = item.getNodeName();

            if ( nodeName.equals( "address" ) ) {
                address = item.getChildNodes().item( 0 ).getNodeValue();
            }

            if ( nodeName.equals( "name" ) ) {
                name = item.getChildNodes().item( 0 ).getNodeValue();
            }
        }

        System.out.println( "address: " + address );
        System.out.println( "name: " + name );
    }