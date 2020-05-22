char grade;
for(int x=1; x<6; x++){
    System.out.print("Please enter your course grade here: ");
    grade = (char) System.in.read();
    while (grade == '\n')
        grade = (char) System.in.read();
}
System.out.println("Thank you! Keep up the good work!");
}