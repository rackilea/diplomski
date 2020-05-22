@JsonRawValue
public String getAdditionalData()
{
    String json = "[";
    List<String> keys = new ArrayList<>(additionalData.keySet());
    for (int i = 0; i < keys.size(); i++) {
        String key = keys.get(i);
        json = json + "\"" + key + "\":\"" + additionalData.get(key) + "\"";
        if (i + 1 < keys.size()) {
            json = json + ",";
        }
    }
    return json + "]";
}