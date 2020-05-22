import java.io.*;
import java.util.Scanner;

public class checkbinary
{
    public boolean checkBinary(String num) {
        for(i=0;i<num.length();i++) {
            digit = Integer.parseInt(num.substring(i,i+1));
            if(digit > 1) { 
                return false;
            }
         }
         return true;
    }

    public static void main(String[] args)
    {
        String num;
        System.out.println("Enter a number:");
        Scanner sc = new Scanner(System.in);
        num = sc.nextLine();
        if(checkBinary(num)) {
            System.out.println("The number is: Binary");
        } else {
            System.out.println("The number is: Not Binary");
        }
    } 
}