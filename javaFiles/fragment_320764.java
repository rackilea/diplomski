import java.io.*;
import java.util.*;

public class CandidateCode{

public static void main(String args1[]) throws Exception
{
    Scanner sc=new Scanner(System.in);
    String s=sc.next();
    int first=Integer.parseInt(s.substring(0,s.indexOf("~")));
    int second=Integer.parseInt(s.substring(s.indexOf("~")+1));
    int [] array=new int[10];
    array[0]=first;
    array[1]=second;
    int i;
    for(i=2;i<10;i++)
    {
        array[i]=first+second;
        first=array[i-1];
        second=array[i];
    }
    System.out.print("{"+array[0]);
    for(i=1;i<10;i++)
    {
        System.out.print(","+array[i]);
    }
    System.out.print("}");
}
}