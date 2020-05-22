class NamesHolder {

    @JsonProperty("name")
    public String singleName;

    @JsonProperty("names")
    public Map<String, String> nameMap;

    @Override
    public String toString() {
        return "NamesHolder{" +
                "name='" + singleName + '\'' +
                ", names=" + nameMap +
                '}';
    }
}