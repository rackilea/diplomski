public class Foos {

@JsonIgnore
private Map<String, Object> properties = new HashMap<String, Object>();

@JsonAnyGetter
public Map<String, Object> getProperties() {
return this.properties;
}

@JsonAnySetter
public void setProperty(String name, Object value) {
this.properties.put(name, value);
}
}