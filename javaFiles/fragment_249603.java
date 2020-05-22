String filepath = "/home/sample.xml"; //this file contains unecaped xml 
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document xmlDoc = docBuilder.parse(filepath);
            Node Order = xmlDoc.getElementsByTagName("Order").item(0);
            NamedNodeMap attr = Order.getAttributes();
            Node no = attr.getNamedItem("No");
            System.out.println("Order no : " + no.getNodeValue());