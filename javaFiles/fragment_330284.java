public class XmlDataSource {

    public String getTranslation(String original) throws Exception {
        Document d = readData();
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xpath = xPathfactory.newXPath();
        XPathExpression expr = xpath.compile("/dictionary/entry/translation[../original/text() = '" + original + "']");
        String translated = (String) expr.evaluate(d, XPathConstants.STRING);
        return translated;
    }

    private Document readData() throws Exception {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        File datafile = new File("your/path/to/translations.xml");
        return documentBuilder.parse(new FileInputStream(datafile));
    }
}