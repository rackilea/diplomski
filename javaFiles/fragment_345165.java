public static void main(String... args) throws SAXException, IOException, ParserConfigurationException {
    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
            .parse(new File("/home/william/Documents/test.xml"));
    doc.getDocumentElement().normalize();

    NodeList nodeList = doc.getElementsByTagName("solution");
    for (int i = 0; i < nodeList.getLength(); i++) {
        Node solutionNode = nodeList.item(i);

        try {
            System.out.println(Solution.newInstance(solutionNode).toString());
        } catch (Exception e) {
            // do something
            e.printStackTrace();
        }   
    }
}