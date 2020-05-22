public List<Contact> queryContacts(String contactName) {
    List<Contact> contactsList = new ArrayList<>();
    for (Contact contact : this.contacts) {
        if (contact.equals(contactName)) { 
            contactsList.add(contact);
        }
    }
    return contactsList;
}