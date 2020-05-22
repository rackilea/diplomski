// for serialization
@JsonIgnore 
public String getName() {
    return name;
}
// for deserialization
@JsonProperty("name")
public void setName(String name) {
    this.name = name;
}