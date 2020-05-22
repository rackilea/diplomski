NodeList itemsNodeList = inputDoc.getElementsByTagName("sequence");
Node resultSequence= resultDoc.getElementsByTagName("sequence").item(0);

NodeList resultChildren=resultSequence.getChildNodes();
for(int i=0;i<resultChildren.getLength();i++) {
    resultSequence.removeChild(resultChildren.item(i));
}

for (int i = 0; i < itemsNodeList.getLength(); i++) {
    NodeList children=itemsNodeList.item(i).getChildNodes();
    for(int j=0;j<children.getLength();j++) {
        Node copiedNode = resultDoc.importNode(children.item(j), true);
        resultSequence.appendChild(copiedNode);
    }
}