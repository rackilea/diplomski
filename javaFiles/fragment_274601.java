public class Bean implements Serializable {
    private Map<String, String> properties = new HashMap<>();

    public String get(String property) {
        return properties.get(property);
    }

    public void set(String property, String value) {
        properties.put(property, value);
    }

    public String getFirstName(){
        return get("firstName");
    }

    public void setFirstName(String firstName){
        set("firstName", firstName);
    }

    public String getLastName(){
        return get("lastName");
    }

    public void setLastName(String lastName){
        set("lastName", lastName);
    }

}