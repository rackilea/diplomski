public class SerializableJSONArray implements Serializable {
    private transient JSONArray jsonArray;

    public SerializableJSONArray(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public JSONArray getJSONArray() {
        return jsonArray;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(jsonArray.toString());
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException, JSONException {
        ois.defaultReadObject();
        jsonArray = new JSONArray((String) ois.readObject());
    }
}