public class MyObj implements Serializable {
    private transient Map<String, Object> myHash = new HashMap<String, Object>();

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        myHash = new HashMap<String, Object>();
    }
}