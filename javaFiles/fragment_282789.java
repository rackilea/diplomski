class User {
    @XmlID
    @XmlJavaTypeAdapter(WSLongAdapter.class)
    @XmlElement(type=Long.class)
    private long id;
    // Other variables
    // Getter & Setter method
}