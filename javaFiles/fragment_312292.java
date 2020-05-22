String names= "";
for(int cntr = 0; cntr < numStudents; cntr++) { 
    System.out.print("Enter student name: ");
    studentName = input.nextLine();

    System.out.print("Enter " + studentName +"'s numeric grade: ");
    numGrade = input.nextInt();
    cleanUpStr = input.nextLine();
    names += studentName + " " + numGrade + "\n";
}
System.out.println(names);