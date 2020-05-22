@XmlRootElement
public class Contacts {
   private List<Contact> contacts;

   //Getter for contacts
   @XMLElement(name = "listContacts")
   public List<Contact> getContacts() {
....


// Getters, setters, default constructor
}