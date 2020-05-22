Scanner input = new Scanner(System.in);

System.out.print("Enter the number of students: ");
int numberOfStudents = input.nextInt();

String[] students = new String[numberOfStudents];

// input.nextLine();

for (int i = 0; i < students.length; i++) {
    System.out.println("Enter name for student " + (i + 1) + ":");
    students[i] = input.next();

}

for (int i = 0; i < students.length; i++) {
    System.out.println(students[i]);

}