Map<Integer, City> to = new HashMap<>();
Map<Integer, City> from = new HashMap<>();

protected void parse() {
    try {
        URL url = new URL("https://raw.githubusercontent.com/kushagrakhare/g/master/test.xml");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new InputSource(url.openStream()));
        doc.getDocumentElement().normalize();

        NodeList nodeList = doc.getElementsByTagName("a:CityPair");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Element el = (Element) nodeList.item(i);
            // get the a:W value
            String fromCityName = el.getElementsByTagName("a:FromCityName").item(0).getTextContent();
            int fromCityID = Integer.parseInt(el.getElementsByTagName("a:FromCityID").item(0).getTextContent());
            int toCityID = Integer.parseInt(el.getElementsByTagName("a:ToCityID").item(0).getTextContent());
            String toCityName = el.getElementsByTagName("a:ToCityName").item(0).getTextContent();

            City from1 = new City(fromCityID, fromCityName);
            City to1 = new City(toCityID, toCityName);
            from.put(fromCityID, from1);
            to.put(toCityID, to1);
        }

        for (City item : from.values()) {
            title.add(item.getName());
        }

        for (City item : to.values()) {
            title2.add(item.getName());
        }

    } catch (Exception e) {
        System.out.println("XML Pasing Excpetion = " + e);
    }

}