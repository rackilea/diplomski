if (is.available() > 0) {
        SOAPMessage message = MessageFactory.newInstance("SOAP 1.2 Protocol").createMessage(null, is);
        Document requestDocument = message.getSOAPBody().extractContentAsDocument();
        NodeList nodes = requestDocument.getChildNodes();
        //get parent node 1
        Node parentNode = nodes.item(0);
        //get child nodes, of parent node
        NodeList childNodes = parentNode.getChildNodes();
        //get first child node since theres only one in the example xml
        Node childNode = childNodes.item(0);
        //print type, value, etc
        System.out.println(childNode.getNodeType() + " = " + childNode.getNodeName() + "/" + childNode.getNodeValue());
        encryptedCode = childNode.getNodeValue();
    }