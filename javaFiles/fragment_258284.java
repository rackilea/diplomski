public class Property {

    private String propKey;
    private String propValue;

    public Property(String propKey, String propValue) {
        this.propKey = propKey;
        this.propValue = propValue;
    }

    public String getPropKey() {
        return propKey;
    }

    public void setPropKey(String propKey) {
        this.propKey = propKey;
    }

    public String getPropValue() {
        return propValue;
    }

    public void setPropValue(String propValue) {
        this.propValue = propValue;
    }
}