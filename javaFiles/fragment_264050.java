public class Example {
    @XmlRootElement("test")
    @XmlAccessorType(XmlAccessType.FIELD)
    public static class Tester {

        int[][] stuff;
    }

    public static void main(String[] args) throws JAXBException {
        Tester tester = new Tester();

        tester.stuff = new int[][]{{1, 2}, {3, 4}};

        StringWriter writer = new StringWriter();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JaxbAnnotationModule());

        System.out.println(objectMapper.writeValueAsString(tester));
    }
}