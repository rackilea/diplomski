for (int i = 0; i < 50; i++){
  System.out.println("Enter students name: ");
  String studentName = input.nextLine();

  name[i] = studentName;

  System.out.println("Enter students grade = ");
  int studentGrade = input.nextInt();

  grade [i] = studentGrade;

  // Using print statements to check the values in your array...
  System.out.println("Name stored in name array is " + name[i]);
  System.out.println("Grade stored in grade array is " + grade[i]);
}