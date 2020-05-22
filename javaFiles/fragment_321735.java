/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
    public static void main (String[] args) throws java.lang.Exception
    {
        try{
        int n, sum = 0;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
        {
            a[i] = s.nextInt();
        }

        int largest=0;
        int element=0;


        for(int i = 0; i < n; i++){
            for(int j=0;j<n;j++){
                element=a[i]%a[j];
                if(largest<element){
                    largest=element;
                }
            }
        }
        System.out.println(largest);
    }
            catch(Exception e){

    }
    }

}