class NativeMemoryCache{
  private Map<Object, ByteBuffer> data = new HashMap<...>();

  public void put(Object key, Serializable object){
    byte[] bytes = serialize(object);
    //allocate native memory to store our object
    ByteBuffer buf = ByteBuffer.allocateDirect(bytes.length);
    buf.put(bytes);
    buf.flip();
    data.put(key, buf);
  }

  public Object get(Object key){
    ByteBuffer buf = data.get(key).duplicate();
    byte[] bytes = new byte[buf.remaining()];
    buf.get(bytes);
    return deserialize(bytes);
  }

  private byte[] serialize(Object obj){ ... }
  private Object deserialize(byte[] bytes){ ... }
}