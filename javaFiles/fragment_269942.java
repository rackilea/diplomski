// Create or use your existing ObjectMapper
ObjectMapper om = new ObjectMapper();

@JsonProperty("JSONString")
public String getJSONString() {
    if (this.jsonString == null)
        return null;
    return om.writeValueAsString(this.jsonString);
}

public void setJSONString(String s) {
    this.jsonString = om.readValue(s, JSONString.class);
}