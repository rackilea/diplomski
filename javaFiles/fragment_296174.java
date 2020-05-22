public class AnotherClass {
    @XmlElement(name = "useThisName")
    @JsonProperty("useThisName")
    private String someField;
    private String anotherField;
}