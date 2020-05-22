public void addContact(Contact contact){
    for(int i = 0; i < this.contacts.size(); i++){
        if(this.contacts.get(i).equals(contact)){
            System.out.println("Contact already exists.");
            return;
        }
    }

    this.contacts.add(contact);
    System.out.println("New contact: " + contact.getName() + " - "
        + contact.getNumber() + " added.");
}