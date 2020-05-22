/** Getter and Setters added for Jackson discovery **/
public class Text {

    private String content;

    public void setContent(String content) { this.content = content; }
    protected String getContent() { return content; }

    @Override @JsonValue
    public String toString() { return content; }
}