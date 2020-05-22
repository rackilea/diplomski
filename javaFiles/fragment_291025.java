try {
            URL url = new URL(/*your xml url*/);
            URLConnection conn = url.openConnection();

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(conn.getInputStream());

            NodeList nodes = doc.getElementsByTagName(/*tag from xml file*/);
            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);
                NodeList title = element.getElementsByTagName(/*item within the tag*/);
                Element line = (Element) title.item(0);
                phoneNumberList.add(line.getTextContent());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }