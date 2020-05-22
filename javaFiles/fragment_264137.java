System.out.println(((Element) nodez).getElementsByTagName("symbol").item(0).getNodeName());
        // get all nodes
        NodeList nl=((Element) nodez).getElementsByTagName("*");
        for (int i = 0; i < nl.getLength(); i++) {
            System.out.println(nl.item(i).getNodeName());
        }