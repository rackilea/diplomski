MyDoc doc = load(MyDoc.class, "/mydoc.xml");

private <T> T load(Class<T> klazz, String xmlResource) {
    try {
        JAXBContext jaxbContext = JAXBContext.newInstance(klazz);
        return klazz.cast(jaxbContext.createUnmarshaller()
                .unmarshal(getClass().getResourceAsStream(xmlResource)));
    } catch (JAXBException e) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE,
                "Cannot read resource " + xmlResource, e);
        throw new IllegalStateException(e);
    }
}

@XmlRootElement(name="document")
public class MyDoc {

    @XmlElement(name="sweetsList")
    public List<Sweets> sweets= new ArrayList<>();
}

<document>
    <sweetsList>
        ...
    </sweetsList>
</document>