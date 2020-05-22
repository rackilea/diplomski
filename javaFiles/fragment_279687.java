@Test
public void testXml() throws JAXBException {

    final JAXBContext context = JAXBContext.newInstance(Info.class);

    final Info marshall = new Info();
    marshall.getMap().put(1, Item.newInstance(1, "value1"));
    marshall.getMap().put(2, Item.newInstance(2, "value2"));

    final Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

    final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    marshaller.marshal(marshall, baos);
    System.out.println(new String(baos.toByteArray()));

    final Unmarshaller unmarshaller = context.createUnmarshaller();

    final Info unmarshal = (Info) unmarshaller.unmarshal(
        new ByteArrayInputStream(baos.toByteArray()));

    for (Item item : unmarshal.getMap().values()) {
        System.out.println(item);
    }
}