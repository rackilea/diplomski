import java.util.*;
import java.io.*;

public class testInput
{
   static Scanner testanswers;
   static PrintWriter testresults;

   public static void main(String[] args) throws IOException
   {
        testanswers = new Scanner(new FileReader("TestInput.dat"));

        String StudentID;
        String answers;
        // Read first two lines first to know how many records there are.
        String answerKey = testanswers.nextLine();
        int count = Integer.parseInt(testanswers.nextLine());

        // Allocate the array for the size needed.
        String[][] answerArray = new String[count][];

        for (int i = 0; i < count; i++)
        {
            String line = testanswers.nextLine();
            answerArray[i] = line.split(" ", 2);
        }


        for(int row = 0; row < answerArray.length; row++)
        {
             for(int col = 0; col < answerArray[row].length; col++)
             {
                  System.out.print(answerArray[row][col]);
             }
             System.out.println();
        }


   }

}