import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
     public static int[] array;

     public static void main(String[] args)
     {
        array = new int[25];
        for(int i=0; i<25; i++)
           array[i] = i + 1;   
        printArray();
     }

     public static void printArray()

     {
        int i;
        for(i=1; i<=25; i++){
            if (i % 5 != 0)
                System.out.print(array[i-1]+",");
            else
                System.out.println(array[i-1]);
       }
     }
}