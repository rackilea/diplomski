try {

     URL url = new URL("http://myurl");
     URLConnection conn = url.openConnection();

     DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
     DocumentBuilder builder = factory.newDocumentBuilder();
     Document doc = builder.parse(conn.getInputStream());

     NodeList nodes = doc.getElementsByTagName("FLIGHT");
     for (int i = 0; i < nodes.getLength(); i++) {
        Element element = (Element) nodes.item(i);
        String airport = element.getAttribute("airport");

        System.out.println("element " + i + ": airport=" + airport);
     }
  } catch (Exception e) {
     e.printStackTrace();
  }