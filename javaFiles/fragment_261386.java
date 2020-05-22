public class Requirement {
private String body;

@JsonProperty("description")
private void unpackNested(Map<String,Object> description) {
    this.body = (String)description.get("body");
}