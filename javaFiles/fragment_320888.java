public class Impl extends Parser<ContactList>{
    public abstract ContactList parse(JSONObject jsonObject){
        ContactList contactList = new ContactList();
        //Simplified for clearness
        contactList = parse(jsonObject);
        return contactList;
    }
}