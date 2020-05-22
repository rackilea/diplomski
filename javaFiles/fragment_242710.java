System.out.println("Enter Employee First Name: ");
    String tempFirstName = input.next();
    employeesArray[i].setFirstName(tempFirstName);

    System.out.println("Enter Employee Last Name: ");
    String tempLastName = input.next();
    employeesArray[i].setLastName(tempLastName);

    //feed this to move the scanner to next line
    input.nextLine(); 

    System.out.println("Enter Employee Address: ");
    String tempAddress = input.nextLine();
    employeesArray[i].setAddress(tempAddress);

    System.out.println("Enter Employee Title: ");
    String tempTitle = input.next();
    employeesArray[i].setTitle(tempTitle);