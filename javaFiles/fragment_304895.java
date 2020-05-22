public class Contact implements Comparable<Contact> {

    //.....other code, getters and setters

    @Override
    public int compareTo(Contact c2) {
        return c2.getMycontactType().compareToIgnoreCase(this.getMycontactType());      
    }
}