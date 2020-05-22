// write the class
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream oos = new ObjectOutputStream(baos);
oos.writeObject(objectToSerialize);

// this you need to store
byte[] data = baos.toByteArray();

// read it again (just a test)
ByteArrayInputStream bais = new ByteArrayInputStream(data);
Object restored = new ObjectInputStream(bais).readObject();

// write what came from the deserialization
System.out.println(restored);