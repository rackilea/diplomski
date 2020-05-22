class SomePojo {
    public JSONObject json;
    @JsonInclude(Include.NON_NULL)
    @JsonProperty(value = "jsondata")
    public String getJson() {
        return json.toString();
    }
}