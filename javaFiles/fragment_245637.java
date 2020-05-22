Element root = doc.getDocumentElement(); //Network
            for (int i = 0; i < root.getChildNodes().getLength(); i++) {
                Node n = root.getChildNodes().item(i);
                if (n instanceof Element) {
                    NodeList nodes = n.getChildNodes();
                    for (int j = 0; j < nodes.getLength(); j++) {
                        Node theNode = nodes.item(j);
                        if (theNode instanceof Element) {
                            System.out.println(((Element) theNode).getAttribute("id"));
                        }
                    }
                }
            }