public void addContact(Person p) {

    for(int i = 0;  i < ArrayOfContacts.size(); i++) {
        Person contact = ArrayOfContacts.get(i);
        if(contact.getID() == p.getID()) {
            System.out.println("Sorry this contact already exists.");
            return; // the id exists, so we exit the method. 
        }
    }

    // Otherwise... you've checked all the elements, and have not found a duplicate
    ArrayOfContacts.add(p);

}