NodeList nList = doc.getElementsByTagName("foo");
        for (int temp = 0; temp < nList.getLength(); temp++) { // loop for foo
            Node nodeTable = nList.item(temp);
            Element xmlFoo = (Element) nodeTable;
            if (nodeTable.getNodeType() == Node.ELEMENT_NODE) {
            NodeList nodeListFoo1 = xmlFoo.getElementsByTagName("foo1");
            for (int i = 0; i < nodeListFoo1.getLength(); i++) { // loop for foo1
                Node nodefoo2 = nodeListFoo1.item(i);
                Element elementfoo1 = (Element) nodefoo2;
                // Collect foo2 
                NodeList nodeListfoo2Name = elementfoo1.getElementsByTagName("foo2");
                for (int j = 0; j < nodeListfoo2Name.getLength(); j++) { //// loop for foo2
                    Node nodefoo2Name = nodeListfoo2Name.item(j);
                    Element elementfoo2Name = (Element) nodefoo2Name;
                    //TODO: write code here, what you want to collect from foo2
                    }
                }
            }
        }