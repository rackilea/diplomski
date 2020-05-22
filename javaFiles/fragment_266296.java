NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(doc, XPathConstants.NODESET);
        int length = nodeList.getLength();
     if ( length > 0 )
     {
         Node nNode = nodeList.item(0);
         response = nNode.getNodeValue();
     }