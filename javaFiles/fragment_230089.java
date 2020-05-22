public class Adif2Record {

    private final Map<String, String> data = new HashMap<>();

    public void setData(String key, String value) {
        data.put(key, value);
    }

    public Map<String, String> getData() {
        return data;
    }
}