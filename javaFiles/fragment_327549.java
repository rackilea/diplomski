@JsonRawValue
@JsonInclude(Include.NON_NULL)
@JsonProperty(value = "jsondata")
public String getJson() {
    return json.toString();
}