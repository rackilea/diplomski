NodeList nList = doc.getElementsByTagName("item");
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);
            if (node.getNodeType() == Element.ELEMENT_NODE) {
                Element eElement = (Element) node;
                System.out.println(eElement.getAttribute("id"));
                if (eElement.getAttribute("id").equals("s" + index)) {
                    System.err.println("sdsd");
                    node.getParentNode().removeChild(node);
                }
            }
        }