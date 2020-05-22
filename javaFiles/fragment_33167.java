try {

         URL url = new URL("http://www.w3schools.com/xml/note.xml");
         URLConnection conn = url.openConnection();

         DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
         DocumentBuilder builder = factory.newDocumentBuilder();
         Document doc = builder.parse(conn.getInputStream());

         NodeList nodes = doc.getElementsByTagName("note");
         for (int i = 0; i < nodes.getLength(); i++) {
            Element element = (Element) nodes.item(i);
            // NodeList title = element.getElementsByTagName("airport");
            // Element line = (Element) title.item(0);
            // a.add(line.getTextContent());

            System.out.println(element.getTextContent());
         }
      } catch (Exception e) {
         e.printStackTrace();
      }