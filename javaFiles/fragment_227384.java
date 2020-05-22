public static void recursiveNodeList(NodeList nodeList) {
    for(int i = 0; i< nodeList.getLength(); i++) {
        Node fstNode = nodeList.item(i);
        if (fstNode.getNodeType() == Node.ELEMENT_NODE) {             
            Element fstElmnt = (Element) fstNode;

            if(fstElmnt.getChildNodes().getLength() > 1) {
                NodeList fstNmElmntLst = fstElmnt.getChildNodes();
                recursiveNodeList(fstNmElmntLst);
            } else {
                NodeList fstNmElmntLst = fstElmnt.getChildNodes();
                Node node = fstNmElmntLst.item(0);
                if(node != null)
                    if(node.getNodeType() == Node.ELEMENT_NODE) {
                        System.out.println(fstNode.getNodeName()+"->"+node.getNodeName() + "->"+((Element)node).getTextContent());
                    } else {
                        System.out.println(fstNode.getNodeName()+"->"+node.getNodeName() + "->"+node.getNodeValue());
                    }
                }
            }
        }
    }
}