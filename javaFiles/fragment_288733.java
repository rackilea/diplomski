@XmlRootElement(name ="outertag")
@XmlAccessorType(XmlAccessType.FIELD)
public class OuterTag {

    @XmlElement(name = "innerelement")
    private List<InnerElement> innerElemements

    public static InnerElement{
        @XmlAttribute(name = "attribute1")
        protected String attribute1;

        private String innerElementDetail;
        // getters and setters
    }
}