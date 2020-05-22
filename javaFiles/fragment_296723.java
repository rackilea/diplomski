public static void main(String[] args) throws Exception {
    AnyXmlElement any = new AnyXmlElement();
    any.addAttribute(new QName("bar"), "hello");

    Root root = new Root();
    root.any = Arrays.asList(toJAXBElement(new QName("foo"), any));
    // It's important to add AnyXmlElement.class here
    JAXBContext jc = JAXBContext.newInstance(Root.class, AnyXmlElement.class);
    Marshaller m = jc.createMarshaller();
    m.marshal(root, System.out);
}