@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SomeMessage")
public class SomeMessage {

    @XmlAttribute(name = "customIds")
    protected List<CustomId> customIds;

    /**
     * Gets the value of the customIds property.
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CustomId }
     * 
     * 
     */
    public List<CustomId> getCustomIds() {
        if (customIds == null) {
            customIds = new ArrayList<CustomId>();
        }
        return this.customIds;
    }

}