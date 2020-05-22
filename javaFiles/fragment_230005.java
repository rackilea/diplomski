@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "symbolAttribute"
})
@XmlRootElement(name = "quote")
public class Quote {

    @XmlElement(name = "Symbol")
    protected int symbolAttribute;
    @XmlAttribute(name = "symbol", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "NCName")
    protected String symbol;
    ....