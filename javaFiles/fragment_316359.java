import java.util.Scanner;
public class Test1
{
    public static boolean PalindromeChecker(String s)
    {
        if(s.length() == 0 || s.length() == 1)
            return true;
        if(s.charAt(0) == s.charAt(s.length()-1))
            return PalindromeChecker(s.substring(1, s.length()-1));
        return false;
    }
    public static void CharacterNumberCounter(String original) 
    {
        int letters=0,digits=0,blanks=0,length=0;
        char ch;
        for(int i=0;i<original.length();i++)
        {
            ch=original.charAt(i);
            if((ch>=65 && ch<=90 ) ||(ch>=97 && ch<=122 ))
                letters++;
            else if(ch>=48 && ch<=57 )
                digits ++;
            else if(ch==' ')
                blanks ++;
        }
        System.out.println("Letters : " +letters);
        System.out.println("Digits : " +digits);
        System.out.println("Blanks : " +blanks);
    }
    public static void main(String args[])
    {
                Scanner peace=new Scanner(System.in);
                System.out.println("Enter String for Palindrome check");
                System.out.println(PalindromeChecker(peace.nextLine()));
                System.out.println("Enter String for Char count ");
                CharacterNumberCounter(peace.nextLine());
    }
}