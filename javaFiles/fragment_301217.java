String xmlFile = "customer.xml";

            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(xmlFile);

            //Retrieve the third entry node
            Node entryNode = doc.getElementsByTagName("entry").item(3);

            //Set new value
            entryNode.setTextContent("10");

            //Save to file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(xmlFile));
            transformer.transform(source, result);