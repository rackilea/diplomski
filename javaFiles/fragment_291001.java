public static String serialize(Object obj) throws JAXBException
{
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(obj.getClass());
    Marshaller m = context.createMarshaller();

    m.marshal(obj, writer);
    return writer.toString();
}

public static Object deserialize(String xml, Object obj) throws JAXBException
{
    StringBuffer xmlStr = new StringBuffer(xml);
    JAXBContext context = JAXBContext.newInstance(obj.getClass());
    Unmarshaller um = context.createUnmarshaller();

    return um.unmarshal(new StreamSource(new StringReader(xmlStr.toString())));
}