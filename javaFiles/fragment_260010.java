public class Main {

    public static void main(String[] args) {

        org.jdom2.Document jdomDoc;         
        try {   
            jdomDoc = useDOMParser(new File("your_xml_file"));              
            List<Element> products = jdomDoc.getRootElement().getChildren("product");           
            for (Element product : products) {
                System.out.println("----" + product.getAttributeValue("productsname"));
                List<Element> subtypes = product.getChild("Parameters").getChildren("Subtype");
                for (Element subtype : subtypes) {
                    System.out.println("--" + subtype.getAttributeValue("name"));
                    List<Element> types = subtype.getChildren("type");
                    for (Element type : types) {
                        System.out.println(type.getText());
                    }
                }
            }
        } catch (Exception e) {e.printStackTrace();}                
    }

    private static org.jdom2.Document useDOMParser(File fileName)
            throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setIgnoringComments(true);
        DocumentBuilder dBuilder;
        dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fileName);
        DOMBuilder domBuilder = new DOMBuilder();
        return domBuilder.build(doc);

    }   
}