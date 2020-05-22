public class File {
    private String key;
    private String value;

    public File() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = new Gson().toJson(value);
    }
}