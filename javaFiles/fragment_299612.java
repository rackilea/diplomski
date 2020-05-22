Node companyNode = doc.getElementsByTagName("company").item(0);
    NodeList companyChildNodes = companyNode.getChildNodes();
    for (int i = 0; i < companyChildNodes.getLength(); i++) {
        Node node = companyChildNodes.item(i);
        if (node.getNodeType() == Node.ELEMENT_NODE && Objects.equals("staff", node.getNodeName())) {
            System.out.println(node.getTextContent());
            break;
        }
    }