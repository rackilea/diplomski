public static void main(String[] args)
{
    JacksonXmlModule module = new JacksonXmlModule();
    XmlMapper mapper = new XmlMapper(module);
    ListTest lt = new ListTest();
    lt.line.add("A");
    lt.line.add("B");
    lt.line.add("C");
    try {
        mapper.writeValue(System.out, lt);
    } catch (Exception e) {
        e.printStackTrace();
    }
}