public static void getLetterGrade (int studentGrade) {
    if (studentGrade >= 90) System.out.println("A");
    else if (studentGrade >= 80) System.out.println("B");
    else if (studentGrade >= 70) System.out.println("C");
    else if (studentGrade >= 60) System.out.println("D");
    else if (studentGrade >= 0) System.out.println("F");
    else System.out.println("You have entered an incorrect integer.");
}