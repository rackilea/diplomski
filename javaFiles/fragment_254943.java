// Serialize to a byte array
ByteArrayOutputStream bos = new ByteArrayOutputStream();
out = new ObjectOutputStream(bos);
out.writeObject(object); 
out.close(); 

// Get the bytes of the serialized object
byte[] buf = bos.toByteArray();