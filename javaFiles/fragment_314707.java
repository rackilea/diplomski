NodeList nodeList1;

    for (int i = 0; i < nodeList.getLength(); i++) {
        System.out.println(nodeList.item(i).getNodeName());
        expression="*";
        nodeList1 = (NodeList) xpath.evaluate(expression,nodeList.item(i),XPathConstants.NODESET);
        for (int j = 0; j < nodeList1.getLength(); j++) {
            System.out.println("\t"+nodeList1.item(j).getNodeName());
        }
    }