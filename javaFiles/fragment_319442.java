import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static List<String> storeResult;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // 0 To end the loop and run output! Repeats until 0 is entered!
        // Arraylist for each of the Vars!
        // Validation
        int studentNumber = 1; //Have to initialise - 1 So it doesn't terminate 
        int studentNumberPassed = 12;
        int cwMark = 0;
        int examMark = 0;

        boolean terminate = false;
        storeResult = new ArrayList<String>();
        while (terminate == false) {
            System.out.print("Student Number: --> ");
            studentNumber = reader.nextInt();
            if (studentNumber == 0) { // Once 0 is inputted to terminate it overwrites.
                terminate = true;
                displayResult();
                return;
            }

            studentNumberPassed = studentNumber; 
            System.out.print("CW Mark: --> ");
            cwMark = reader.nextInt();
            System.out.print("EX Mark: --> ");
            examMark = reader.nextInt();
            result(studentNumberPassed, cwMark, examMark);
        }
    }

    private static void result(int studentNumberPassed, int cwMark, int examMark) {
        int markTotal;
        double markAverage;
        markTotal = examMark + cwMark;
        // Cast to double before calculating
        markAverage = (double) markTotal / 2;
        String str = "sn = " + studentNumberPassed + " ex = " + examMark + " cw = " + cwMark + " mark = " + markAverage;
        storeResult.add(str);

    }

    private static void displayResult() {
        for(int data=0;data<storeResult.size();data++){
            System.out.println(""+storeResult.get(data));
        }
    }
}