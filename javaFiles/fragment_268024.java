import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Exam {

    public static void main(String[] args) {
        Exam[] exams = Exam.readAllExams(new Scanner(
                "Firstname Lastname 1 ExamType 2\n"
                + "Chuck Norris 42 Roundhousekicking 100\n"
                + "Sponge Bob 43 Burgermaking 50"));
        System.out.println(Arrays.toString(exams));
    }

    private String firstName;
    private String lastName;
    private int ID;
    private String examType;
    private int score;

    public Exam(String firstName, String lastName, int ID, String examType, int score)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.examType = examType;
        this.score = score;
    }

    public String toString() {
        return String.format("Exam: (firstName: %s, lastName: %s, ID: %d, " 
                +"examType: %s, score: %d)", 
                firstName, lastName, ID, examType, score);
    }

    public static Exam[] readAllExams(Scanner s)
    {
        ArrayList<Exam> anyNumberofExams = new ArrayList<>();
        while (s.hasNext()) {
            anyNumberofExams.add(new Exam(s.next(), s.next(), s.nextInt(), 
                    s.next(), s.nextInt()));
        }
        return anyNumberofExams.toArray(new Exam[0]);
    }

}