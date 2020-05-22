@JacksonXmlRootElement(localName = "id")
    @Data //for getters and setters
    public class Id {
    @JacksonXmlProperty(isAttribute=true)
    String type;
    @JacksonXmlText
    String text;
}