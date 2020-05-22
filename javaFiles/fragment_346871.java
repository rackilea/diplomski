DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
dbf.setValidating(false);
DocumentBuilder db = dbf.newDocumentBuilder();

File file = new File("Result.xml");

String baseXml = "blank.xml";

String[] inputXmls = {"input1.xml","input2.xml"};

Document resultDoc = db.parse(baseXml);

Node resultConfigsNode = resultDoc.getElementsByTagName("Configs").item(0);
Node resultRatingsBodyNode = resultDoc.getElementsByTagName("body").item(0);

for (String inputXml : inputXmls){
    Document inputDoc = db.parse(inputXml);

    NodeList configNodeList = inputDoc.getElementsByTagName("Config");

    for (int i = 0; i < configNodeList.getLength(); i++) {
        Node copiedNode = resultDoc.importNode(configNodeList.item(i), true);
        resultConfigsNode.appendChild(copiedNode);
    }

    for (int i = 0; i < itemsNodeList.getLength(); i++) {
        Node copiedNode = resultDoc.importNode(itemsNodeList.item(i), true);
        NamedNodeMap attrMap = copiedNode.getAttributes();
        Node n = attrMap.getNamedItem("name");
        if(n.getNodeValue().equals("object 1")){
            System.out.println("Items object 1");
        }
        resultRatingsBodyNode.appendChild(copiedNode);
    }

    NodeList valueNodeList = inputDoc.getElementsByTagName("value");
    for (int i = 0; i < valueNodeList.getLength(); i++) {
        Node copiedNode = resultDoc.importNode(valueNodeList.item(i), true);
        Text txt = (Text) copiedNode.getFirstChild();
        txt.setData("NewValue");
        resultRatingsBodyNode.appendChild(copiedNode);
    }

}
processXml(resultDoc, file);