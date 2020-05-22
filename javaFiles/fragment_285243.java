Scanner stdin = new Scanner(System.in);
System.out.println("Enter a set of grades:");
boolean validGrade = true;

while (validGrade) {
    count += 1;
    char grade = stdin.next().charAt(0);
    if (grade == 'A') {
        gpa += 4.0;
        System.out.println("Grade Inputted");
    } else if (grade == 'B') {
        gpa += 3.0;
        System.out.println("Grade Inputted");
    } else if (grade == 'C') {
        gpa += 2.0;
        System.out.println("Grade Inputted");
    } else if (grade == 'D') {
        gpa += 1.0;
        System.out.println("Grade Inputted");
    } else if (grade == 'F') {
        gotF = true;
        System.out.println("Grade Inputted");
    } else {
        validGrade = false;
    }
}

gpa = gpa / count;
System.out.println("Your GPA is: " + gpa);