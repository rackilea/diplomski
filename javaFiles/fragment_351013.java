import java.util.Scanner;

public class Grading {
     private int quiz1, quiz2, quiz3, midterm, finalExam; //quizzes exams tests what grades

public void readInput () {
    Scanner in = new Scanner(System.in);
    System.out.print("Please enter the grade you got for the first quiz: ");
    quiz1 = readInt(in, 0, 10);

    System.out.print("Please enter the grade you got for the second quiz: ");
    quiz2 = readInt(in, 0, 10);

    System.out.print("Please enter the grade you got for the third quiz: ");
    quiz3 = readInt(in, 0, 10);

    System.out.print("Please enter the grade you got on your midterm: ");
    midterm = readInt(in, 0, 100);

    System.out.print("Please enter the grade you got on your final exam: ");
    finalExam = readInt(in, 0, 100);
}

public void output () {
    System.out.println("Your score for the first quiz was " + quiz1);
    System.out.println("Your score for the second quiz was " + quiz2);
    System.out.println("Your score for the third quiz was " + quiz3);
    System.out.println("Your score for the midterm was " + midterm);
    System.out.println("Your score for the final exam was " + finalExam);

    //dunno if this is the way you want to count it; change as needed
    double quizzes    = (quiz1 + quiz2 + quiz3) / 100 * 0.25;
    double Pmidterm   = midterm / 100 * 0.25;
    double PfinalExam = finalExam /100 * 0.50;
    double totalGrade = (quizzes + Pmidterm + PfinalExam) * 100.0;

    char grade;
    if (totalGrade >= 90)
        grade = 'A';
    else if (totalGrade >= 80)
        grade = 'B';
    else if (totalGrade >= 70)
        grade = 'C';
    else if (totalGrade >= 60)
        grade = 'D';
    else grade = 'F';

    System.out.printf("Your grade is %c\n", grade);
}

private int readInt (Scanner in, int min, int max) {
    int value = in.nextInt();
    if (value < min || value > max) {
        System.out.printf("Please enter a grade between %d and %d: ", min, max);
        return readInt(in, min, max);
    }
    return value;
}

public static void main(String[] args) {
    Grading grading = new Grading();
    grading.readInput();
    grading.output();
}
}