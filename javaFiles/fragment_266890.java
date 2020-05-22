public class Test {
    public Test() {
    }
    public static void main(String[] args) {
        try {
            StringReader reader = new StringReader("<xml></xml>");
            JAXBContext jc = JAXBContext.newInstance(TestXML.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            TestXML testXMLs = (TestXML) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}