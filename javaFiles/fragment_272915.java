public class Message implements Serializable {

  private transient String header;
  private transient String body;

  ...
  // custom write object that writes header first and then body
  private void writeObject(java.io.ObjectOutputStream oos)
      throws IOException {
    oos.defaultWriteObject();
    // explicitly store the transient fields
    oos.writeObject(header);
    oos.writeObject(body);
  }

  private void readObject(java.io.ObjectInputStream ois) 
      throws IOException, ClassNotFoundException {
    ois.defaultReadObject();
    // explicitly read in the transient fields
    header = (String) ois.readObject();
    if (needBody()) { // use some static/thread local variable to set this condition
      body = (String) ois.readObject();
    }
  }
}