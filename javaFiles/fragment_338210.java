import java.io.*;
class FinalGrade
{
    //declare variables
    String name;
    double quizTotal = 0;
    double midterm = 0;
    double exam = 0;
    double mark = 0;
    char grade;


    //initialize variables
    public FinalGrade (String nameStudent, double quizMark, double midtermMark, double examMark)
    {
        name = nameStudent;
        quizTotal = quizMark;
        midterm = midtermMark;
        exam = examMark;
    }

    public void marks()
    {
        mark = ((exam * 0.25) + (midterm * 0.25) + (quizTotal * 0.50));

        if (mark >= 90)
        {
            grade = 'A';
        }
        else if (mark >= 80)
        {
            grade = 'B';
        }
        else if (mark >= 70)
        {
            grade = 'C';
        }
        else if (mark >= 60)
        {
            grade = 'D';
        }
        else
        {
            grade = 'F';
        }

        System.out.println((name) + ", your mark is " + (mark) + " and you get a(n) " + (grade));




    }
}



class finalGradeTester
{
    public static void main(String[] args)
    {
    InputStreamReader inStream = new InputStreamReader(System.in);
    BufferedReader sub = new BufferedReader(inStream);

    FinalGrade student1 = new FinalGrade("Student", 89, 100, 21);
    FinalGrade student2 = new FinalGrade("Student", 34, 21, 9);
    FinalGrade student3 = new FinalGrade("Student", 89, 100, 21);
    FinalGrade student4 = new FinalGrade("Student", 89, 100, 21);
    FinalGrade student5 = new FinalGrade("Student", 89, 100, 21);

    student1.marks();
    student2.marks();

    }

}