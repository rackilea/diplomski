ByteArrayOutputStream baos = new ByteArrayOutputStream();
new ObjectOutputStream(baos).writeObject(object);
String serializedObject = Base64.encode(baos.toByteArray());

byte[] bytes = Base64.decode(serializedObject);
ByteArrayInputStream baos = new ByteArrayInputStream(bytes);
Object object = new ObjectInputStream(baos).readObject()