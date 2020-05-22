import java.util.*;

public class Test {
    public static void main(String... args) {
        new Test().askForMarks(5);
    }

    public void askForMarks(int student) {
        double marks[] = new double[student];
        int index = 0;
        Scanner reader = new Scanner(System.in);
        while (index < student) {
            System.out.print("Please enter a mark (0..30): ");
            marks[index] = (double) checkValueWithin(0, 30); 
            index++;
        }
    }

    public double checkValueWithin(int min, int max) {
        double num;
        Scanner reader = new Scanner(System.in);
        num = reader.nextDouble();                         
        while (num < min || num > max) {                 
            System.out.print("Invalid. Re-enter number: "); 
            num = reader.nextDouble();                         
        } 

        return num;
    }
}