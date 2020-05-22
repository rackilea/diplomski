public class FooType {
    @XmlElement(name = "Bar")
    protected BigInteger bar;
    @XmlElement(name = "Baz")
    protected byte[] baz;
    @XmlAnyElement(lax = true)
    protected List<Object> any;
    @XmlAttribute(name = "Moo", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String moo;