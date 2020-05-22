for (int i = 0; i < 3; i++) {
    Student student = new Student(); // new student

    //set name
    System.out.println("Enter Student Name: ");
    student.setName(scanner.nextLine());

    //set ID number
    System.out.println("Enter Student ID Number: ");
    student.setIdNumber(scanner.nextLong());

    inputArray[i] = student; // put new student into array passed to the method

}//end for loop