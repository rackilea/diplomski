public class Test { 

    static class Element {
        @XmlElement
        String attributeName;
        @XmlElement
        @XmlElementWrapper(name="attributeValues")
        List<String> attributeValue;
    }

    @XmlElement
    List<Element> elementAttribute;

    public static void main(String[] args) throws Exception {
        Test t = JAXB.unmarshal(new File("1.xml"), Test.class);
    }
}