DocumentBuilder documentBuilder =
        DocumentBuilderFactory.newInstance().newDocumentBuilder();

String xmlContents = new String(Files.readAllBytes(Paths.get("demo.xml")), "UTF-8");

Document document = documentBuilder.parse(
         new InputSource(new StringReader(xmlContents.replaceAll("&", "&amp;"))
        ));