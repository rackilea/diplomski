for(int i = 0; i < nodes.getLength(); i++) {
        Node node = nodes.item(i);
        NamedNodeMap attributes = node.getAttributes();
        System.out.println(attributes.getNamedItem("id").getTextContent());
        System.out.println(attributes.getNamedItem("label").getTextContent());
    }