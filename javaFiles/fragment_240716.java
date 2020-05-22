input:ab*cd output:ad
input ab**cd  ouput:ad
import java.util.Scanner;

public class Starstring {
    public static void main(String[] args) {
        String str1;
        String res="";
        int n,i=0;

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the string");
        str1=sc.next();
        res=str1;
        str1 = str1.replaceAll("[*]+", "*");// add this line
        StringBuffer a = new StringBuffer(str1);
        n=str1.length()-1;
        for(i=0;i<n;i++)
        {
            if(str1.charAt(i)=='*')
            {
                res=a.delete(i-1, i+2).toString();
            }
        }
        System.out.println("The final string is"+res);
    }

}