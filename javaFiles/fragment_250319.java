@XmlAccessorType(XmlAccessType.FIELD)
public class Switch {
    private Condition Condition;
    private ScalarCase ScalarCase;
    private String Id;
    private String DisplayName;
    private Leaf Leaf;
    @XmlElement(name="Switch")
    private Switch aSwitch;
    // getters and setters
}