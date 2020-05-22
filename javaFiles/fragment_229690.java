public static void main (String[] args) throws java.lang.Exception {
  ArrayList objects = new ArrayList();
  objects.add("Hello World");
  objects.add(new Double(42.0));
  System.out.println(sizeof(objects));               
}

public static int sizeof(Serializable object) {
  ObjectOutputStream out = null;
  ByteArrayOutputStream baos = null;
  try {
    baos = new ByteArrayOutputStream();
    out = new ObjectOutputStream(baos);
    out.writeObject(object);
  } catch (Exception e) {
    e.printStackTrace();
  } finally {
    if (out != null) {
      try {
        out.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  return baos != null? baos.size() : -1;
}