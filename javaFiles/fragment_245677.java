public class PrintUIDs extends ObjectInputStream {

  public PrintUIDs(InputStream in) throws IOException {
    super(in);
  }

  @Override
  protected ObjectStreamClass readClassDescriptor() throws IOException,
      ClassNotFoundException {
    ObjectStreamClass descriptor = super.readClassDescriptor();
    System.out.println("name=" + descriptor.getName());
    System.out.println("serialVersionUID=" + descriptor.getSerialVersionUID());
    return descriptor;
  }

  public static void main(String[] args) throws IOException,
      ClassNotFoundException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ObjectOutputStream oos = new ObjectOutputStream(baos);
    List<Object> list = Arrays.asList((Object) new Date(), UUID.randomUUID());
    oos.writeObject(list);
    oos.close();
    InputStream in = new ByteArrayInputStream(baos.toByteArray());
    ObjectInputStream ois = new PrintUIDs(in);
    ois.readObject();
  }

}