import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
       Scanner input = new Scanner(System.in);
       int numberOfStudents = input.nextInt();
       //input.nextLine();
       String[][] partners = new String[2][numberOfStudents];
       for(int i=0; i<numberOfStudents; i++)
       {
          partners[1][i] = input.nextLine();
       }
    }
}