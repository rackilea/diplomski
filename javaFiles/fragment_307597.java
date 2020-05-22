System.out.println("Enter student name");
sName = input.nextLine();

System.out.println("Enter student age");
sAge = input.nextInt();

System.out.println("Enter student ID");
sID = input.nextInt();

System.out.println("Enter student address");
sAddress = input.nextLine();

System.out.println("Enter student gender");
sGender = input.nextLine();

enrollment en = new enrollment(sName, sAge, sID, sAddress, sGender);

studentData.add(sGender);