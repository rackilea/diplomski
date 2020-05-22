@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "foo")
public class Foo {

    @XmlAttribute
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Double bar;

    /**
     * Gets the value of the bar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Double getBar() {
        return bar;
    }

    /**
     * Sets the value of the bar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBar(Double value) {
        this.bar = value;
    }

}