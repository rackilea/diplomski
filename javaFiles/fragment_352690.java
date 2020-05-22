XPathFactory factory = XPathFactory.newInstance();
XPath xpath = factory.newXPath();
XPathExpression expr = xpath.compile("//venue/*");

Object result = expr.evaluate(document, XPathConstants.NODESET);
NodeList nodes = (NodeList) result;
for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item( i );
            String nodeName = node.getNodeName();
            String nodeValue = node.getChildNodes().item( 0 ).getNodeValue();


            if( nodeName.equals( "name" ) ) {
                        name = nodeValue;
            } 
            else if( nodeName.equals( "address" ) ) {
                        address = nodeValue;
            } // ... the rest goes here
}