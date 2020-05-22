import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int numberOfSubjects, sum;
        numberOfSubjects = 0;

        System.out.print("Enter the total number of subjects: ");
        numberOfSubjects = in.nextInt();

        if(numberOfSubjects < 0){
        System.out.println("Number of marks must be greater than 0!!");
        }
        else {
            int []marks = new int[numberOfSubjects];
            sum = 0;

            System.out.print("Enter the marks: ");
            // add condition inside for loop for marks not less than 1 or greater than 100 
            for(int i=0; i<marks.length; i++) {
                    marks[i] = in.nextInt();
            }

            // calculate total
            for(int i = 0; i < marks.length; i++){
                sum += marks[i];
            }

            // sort marks
            Arrays.sort(marks);

            System.out.println("Total: " + sum);
            System.out.println("Average: " + sum/numberOfSubjects);
            System.out.println("Minimum: " + marks[0]);
            System.out.println("Maximum: " + marks[marks.length-1]);
        }
    }
}