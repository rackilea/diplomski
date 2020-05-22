public class CustomerInfo {

    private String infoType;
    private final Map<String, String> properties = new HashMap<>();

    public void addProperty(String name, String value) {
        properties.put(name, value);
    }

    public Map<String, String> getProperties() {
        return properties;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }
}