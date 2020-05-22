//creating student2 'object'.
StudentRecord student2 = new StudentRecord();

//ask information about student2.
System.out.println("What is your first name?");
String firstName = input.nextLine();
student2.setFirstName(firstName);

//print supplied information to user.
System.out.println("First Name: " + student2.getFirstName());