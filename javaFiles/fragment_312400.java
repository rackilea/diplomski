import java.util.Scanner;
public class Scratch 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the word = > ");
        String word = input.nextLine();
        int flag = 0;
        int x = word.length()-1;
        int i = 0;
        int j = x;
        for(; i<=x/2 && j>=x/2; i++,j--)
        {
            if(word.charAt(i)!=word.charAt(j))
            {
                flag = 1;
                break;
            }

        }
        if(flag==0)
        {
            System.out.printf("The word '%s' is a palindrome", word);
        }
        else 
            System.out.printf("The word '%s' is not a palindrome", word);
    }


}