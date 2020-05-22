public static void serialize(SerializationStreamWriter streamWriter,
    Collection instance) throws SerializationException {
  int size = instance.size();
  streamWriter.writeInt(size);
  for (Object obj : instance) {
    streamWriter.writeObject(obj);
  }
}