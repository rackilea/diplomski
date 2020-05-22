public static boolean checkCourse(String[] courseList, String code) {
    boolean check = false;
    for (int i = 0; i < courseList.length; i++) {
        if (code.equals(courseList[i])) {  // equals instead of == to compare strings
            check = true;
            break; // you have to break loop if it is true because else statement before returned false even if there was the same course code due to null values in next array elements which was not filled yet
        }

    }
    return check;
}

public static double gradeValue(double marks) {
    double grade = 1.0;
    if (marks >= 95) {
        grade = 5.0;
    } else if (marks >= 90) {
        grade = 4.75;
    } else if (marks >= 85) {
        grade = 4.5;
    } else if (marks >= 80) {
        grade = 4.0;
    } else if (marks >= 75) {
        grade = 3.5;
    } else if (marks >= 70) {
        grade = 3.0;
    } else if (marks >= 65) {
        grade = 2.5;
    } else if (marks >= 60) {
        grade = 2;
    } else if (marks < 60) {
        grade = 1;
    }
    return grade;
}

public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter number of courses: ");
    int n = input.nextInt();
    String[] Courses = new String[n];
    int sumOfcreadit = 0;
    int sumOfmarks = 0;

    for (int i = 0; i < Courses.length; i++) {
        System.out.print("Enter a course code: ");
        String code = input.next();
        if (checkCourse(Courses, code)){
            System.out.println("the course already regestered ");
            i--;
            continue; // continue is neccessary to let user write value again if it already exists
        }
        Courses[i] = code;
        System.out.print("Enter a credit: ");
        int credit = input.nextInt();
        System.out.print(" Enter a marks: ");
        int marks = input.nextInt();

        sumOfcreadit += credit;
        sumOfmarks += marks * credit;

    }
    double TotalMarks;
    TotalMarks = sumOfmarks / sumOfcreadit;

    System.out.println("The GPA is: " + gradeValue(TotalMarks));

}