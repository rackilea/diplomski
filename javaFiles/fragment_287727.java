SerializableSingleton single = SerializableSingleton.INSTANCE;
single.setValue(42);
byte[] data;
try(ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos)) {
    oos.writeObject(single);
    oos.flush();
    data = baos.toByteArray();
}

single.setValue(100);

try(ByteArrayInputStream baos = new ByteArrayInputStream(data);
    ObjectInputStream oos = new ObjectInputStream(baos)) {
    Object deserialized = oos.readObject();

    System.out.println(deserialized == single);
    System.out.println(((SerializableSingleton)deserialized).getValue());
}