String firstName = "a";////define the first name
    contact.setFirstName(firstName); //// then set it 
    myContact = contact.getFirstName(); /// then get it
    System.out.println(myContact);

    String lastName = "b";
    contact.setLastName(lastName);
    myContact = contact.getLastName();
    System.out.println(myContact);

    int myNumber = 123;
    contact.setPhoneNumber(myNumber);
    myNumber = contact.getPhoneNumber();
    System.out.println(myNumber);