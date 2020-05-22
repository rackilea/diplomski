System.out.println("Please enter the name "+ (k+1)+position+" of the contact: ");
        String name=KB.next(); //sets the name of what ever the counter is @
        System.out.println("Now enter the phone number: ");
        Int phone=Integer.parseInt(KB.next());; //coz your class take int
        // now create your object
        Test[k]=new PhoneBookEntry(name,phone)