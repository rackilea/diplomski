for (int i = 0; i < NumberOfStudents; i++){
    System.out.print("What is student number " + (i+1) + "'s name?: ");
    String studentName = reader.nextLine();

    array[i] = new Student(studentName); // initialize the array 
}