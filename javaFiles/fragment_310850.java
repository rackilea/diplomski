public class SerializableObject implements Serializable {

    private transient UnserializableObject unserializableObject;

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(unserializableObject.getSerializableProperty());
        oos.writeObject(unserializableObject.getAnotherSerializableProperty());
        // ...
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        unserializableObject = new UnserializableObject();
        unserializableObject.setSerializableProperty((SomeSerializableObject) ois.readObject());
        unserializableObject.setAnotherSerializableProperty((AnotherSerializableObject) ois.readObject());
        // ...
    }

}