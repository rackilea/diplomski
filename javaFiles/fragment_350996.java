import java.io.*;
import java.util.*;

public class FindGrade {
public static final int NUM_SCORE_TYPES = 5;

public static void main(String[] args) {
    Scanner scan = null;
    String quizzes=  "Quizzes";
    String labs= "Labs";
    String lab_attendance=  "Lab_attendance";
    String midterm=  "Midterms";
    int[] quizArray = null;
    int[] labArray = null;
    int[] attendance = null;
    int[] midterms = null;
    int quizgrade = 0;
    int labgrade = 0;
    int attendance_1 = 0;
    int midterms_1 = 0;
    String name;


    try {
        scan = new Scanner(new File("C://Users//Desktop//input.txt"));
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        return;
    }

    // each iteration is for single exam type (ie: Quizzes is the 1st one)
    for (int i = 0; i < NUM_SCORE_TYPES; i++) {

        name = scan.next();
        int numScores = scan.nextInt();
        int maxGrade = scan.nextInt();

        if (name.equals("Quizzes")) {
            quizArray = new int[numScores];
            readScores(quizArray, numScores, scan,maxGrade, quizzes);


        } else if (name.equals("Labs")) {
            labArray = new int[numScores];
            readScores(labArray, numScores, scan,maxGrade, labs);

        } else if (name.equals("Lab_attendance")) {
            attendance = new int[numScores];
            readScores(attendance, numScores, scan,maxGrade,lab_attendance );

        } else if (name.equals("Midterms")) {
            midterms = new int[numScores];
            readScores(midterms, numScores, scan,maxGrade, midterm);

        }

    }

}


public static void readScores(int[] scoreArray, int numScores, Scanner scan, int maxGrade, String name) {
    for (int i = 0; i < numScores; i++) {
        scoreArray[i] = scan.nextInt();
    }
    average(scoreArray, numScores, maxGrade, name);
}

public static int normalize(int[] scoreArray, int maxGrade) {
    int total = 0;
    for (int i = 0; i < scoreArray.length; i++) {
        total += scoreArray[i];
    }
    int percent = Math.round(total * 100 / maxGrade);
    return percent;
}

public static double average(int[] scoreArray, int numScores,int maxGrade, String name) {
    double sum = 0;
    for (int i = 0; i < scoreArray.length; i++) {
        sum += scoreArray[i];
    }
    double average = Math.round((sum / numScores)*100/maxGrade);

    System.out.println( name + ":" + average+" %");

    return average;
}
}