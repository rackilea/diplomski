public class EntityReferencesService {
  //...
  public Person cloneAddressReferences(Person person) {
    try {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      ObjectOutputStream oos = new ObjectOutputStream(baos) {
        {
          enableReplaceObject(true); // Allows objects to be replaced during serialization
        }
        @Override
        protected Object replaceObject(Object obj) throws IOException {
          Object replacedObject = obj;
          // This code could be smart to known what entities to clone
          if (obj instanceof Person) {
            Person p = (Person) obj;
            // using apache bean commons
            p.workAddress = SerializationUtils.clone(p.workAddress);
            p.homeAddress = SerializationUtils.clone(p.homeAddress);
          }
          return replacedObject;
        }
      };
      oos.writeObject(person);
      ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
      ObjectInputStream ois = new ObjectInputStream(bais);
      return (Person) ois.readObject();
    } catch (Exception ex) {}
  }
}