@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SomeMessage")
public class SomeMessage {

    @XmlAttribute(name = "customIds")
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected List<CustomId> customIds;

    /**
     * Gets the value of the customIds property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public List<CustomId> getCustomIds() {
        return customIds;
    }

    /**
     * Sets the value of the customIds property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomIds(List<CustomId> value) {
        this.customIds = value;
    }

}