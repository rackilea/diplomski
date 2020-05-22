String tag = "Table";
        String attr = "diffgr:id";
        String attrValue = "Table1";
        NodeList list = doc.getElementsByTagName("Table");
        Element tableNode = null;
        for (int i = 0; i < list.getLength(); i++) {
            tableNode = ((Element) list.item(i));
            String currentAttrValue = tableNode.getAttribute(attr);
            if (attrValue.equals(currentAttrValue)) {
                break;
            }
        }
        String childTag1 = "rID";
        String childTag2 = "sNo";
        Node child1 = (Node) tableNode.getElementsByTagName(childTag1).item(0);
        Node child2 = (Node) tableNode.getElementsByTagName(childTag2).item(0);
        String rIDValue = child1.getTextContent();
        String sNoValue = child1.getTextContent();