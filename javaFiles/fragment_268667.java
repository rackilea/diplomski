import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        int i;
        int j;
        int count = 0;
        int [][] arr = {{3, 0, 0, 6}, {4, 0, 1, 0}};

        for (i = 0; i < arr.length; i++)
        {
            System.out.println();
            for (j = 0; j < arr[i].length; j++)
            {
                System.out.print(arr[i][j] + ", ");} }
                System.out.println();
            //--------------------------------------------------------------------

            for (i = 0; i<arr.length; i++)
                for (j = 0; j<arr[i].length; j++)
                    if (arr[i][j] == 0)
                    {
                        count++;
                        break;
                    }
            System.out.println("the amount of rows containing zeros = " + count);

            //--------------------------------------------------------------------
            count=0;

            for (i = 0; i<arr[0].length; i++)
                for (j = 0; j<arr.length; j++)
                    if (arr[j][i] == 0)
                    {
                        count++;
                        break;
                    }
            System.out.println("the amount of cols containing zeros = " + count);
    }
}