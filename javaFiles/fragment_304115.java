@Test
public void marshallsDynamicElementName() throws JAXBException {
    JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
    final Characteristics characteristics = new Characteristics();
    final Characteristic characteristic = new Characteristic(
            "store_capacity", "40");
    characteristics.getCharacteristics().add(characteristic);
    context.createMarshaller().marshal(characteristics, System.out);
}