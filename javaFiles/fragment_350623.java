public class StackOverFlowTest {
    public static void main(String[] args){
    JacksonXmlModule module = new JacksonXmlModule();
    module.setDefaultUseWrapper(false);
    XmlMapper xmlMapper = new XmlMapper(module);
    String xmlString="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Person><isActive>true</isActive><id>A01222262</id><name>Bob</name><addresses><address><attributeName>NEWYORK_ADDRESS</attributeName><attributeValue>NY 10003</attributeValue></address><address><attributeName>CALIFORNIA_ADDRESS</attributeName><attributeValue>CA 92336</attributeValue></address></addresses></Person>";
        try {
        Person p=xmlMapper.readValue(xmlString,Person.class);
        System.out.println(p.toString());
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}