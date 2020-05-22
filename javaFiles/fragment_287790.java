import java.io.*;
import java.util.*;

class S
{
public static void main (String args [])
{
    int no = (int)(Math.random() * 10);
    int i = 0;
    for (int x = no; x >= 1; x--)
    {
        for (int y = no; y >= 1; y--)
        {
            if (x > y){
                System.out.print((y+i)+" ") ;
            }
            else{
                System.out.print ("  ");
        }}
        System.out.println();
    i++;
    }
}
}