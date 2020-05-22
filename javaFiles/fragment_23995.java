ByteArrayOutputStream bos = new ByteArrayOutputStream();
ObjectOutput out = null;
try {
  //Assuming that bos is the object to be seriaized
  out = new ObjectOutputStream(bos);   
  out.writeObject(yourObject);
  byte[] yourBytes = bos.toByteArray();
  ...
} finally {
  try {
    if (out != null) {
      out.close();
    }
  } catch (IOException ex) {
    // ignore close exception
  }
  try {
    bos.close();
  } catch (IOException ex) {
    // ignore close exception
  }
}
//Create object from bytes:

ByteArrayInputStream bis = new ByteArrayInputStream(yourBytes);
ObjectInput in = null;
try {
  in = new ObjectInputStream(bis);
  Object o = in.readObject(); 
  ...
} finally {
  try {
    bis.close();
  } catch (IOException ex) {
    // ignore close exception
  }
  try {
    if (in != null) {
      in.close();
    }
  } catch (IOException ex) {
    // ignore close exception
  }
}