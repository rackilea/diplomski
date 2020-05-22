NodeList nodeList = doc.getElementsByTagName("xLabel");
for (int temp = 0; temp < nodeList.getLength(); temp++) {
    Node node = nodeList.item(temp);
    NodeList namexLabelNodes = node.getChildNodes();

    for (int i = 0; i < namexLabelNodes.getLength(); i++) {
        System.out.println(" Name : " + namexLabelNodes.item(i).getTextContent());
    }
}