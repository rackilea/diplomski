ByteArrayOutputStream baos = new ByteArrayOutputStream();
ObjectOutputStream oos = new SurrogateObjectOutputStream(baos); 
oos.writeObject(o);
oos.flush();
oos.close();

byte[] serializedPojo = baos.toByteArray();