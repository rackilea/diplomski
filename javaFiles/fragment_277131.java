import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
    public static int find(char[] array, char[] subs)
    {
        int found = 0;
        for (int x = 0; x < subs.length; x++)
        {
            for (int y = 0; y < array.length; y++)
            {
                if (subs[x] == array[y])
                {
                    found++;

                    // Y is the index of the element found in the original array
                    // we must erase this element so it's not found again.
                    char[] smaller_array = new char[array.length-1];
                    for (int i = 0; i < array.length; i++)
                    {
                        if (i < y)
                            smaller_array[i] = array[i];

                        if (i == y)
                         continue;

                        if (i > y)
                            smaller_array[i-1] = array[i];
                    }

                    array = smaller_array;
                    break;
                }
            }
        }


        return found;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        char[] sub = { 'd','e','f' };

        char[] array1 = { 'a','b','c','d','e','f','x','r' };
        System.out.println("Number of matches with array #1: " + find(array1, sub));

        char[] array2 = { 'g','e','h','i','d','k','x','f' };
        System.out.println("Number of matches with array #2: " + find(array2, sub));

        char[] array3 = { 'd' };
        System.out.println("Number of matches with array #3: " + find(array3, sub));

        char[] array4 = { 'd','d','d' };
        System.out.println("Number of matches with array #4: " + find(array4, sub));

        char[] array5 = { 'd','e','f' };
        System.out.println("Number of matches with array #5: " + find(array5, sub));

        char[] array6 = { 'f','d','e' };
        System.out.println("Number of matches with array #6: " + find(array6, sub));

        char[] array7 = { 'a','b','c','g','h','i','j','k' };
        System.out.println("Number of matches with array #7: " + find(array7, sub));
    }
}