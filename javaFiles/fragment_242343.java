public void addContact(Person p) {
    String pName = p.getFname() + p.getLname();
    for(int i = 0;  i < ArrayOfContacts.size(); i++) {
        Person contact = ArrayOfContacts.get(i);
        String contactName =  contact.getFname() + contact.getLname(); 
        if(contactName.equals(pName)) {
            System.out.println("Sorry this contact already exists.");
            return; // the name exists, so we exit the method. 
        }
    }

    // Otherwise... you've checked all the elements, and have not found a duplicate
    ArrayOfContacts.add(p);

}