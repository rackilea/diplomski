import java.util.Scanner;

public class PigLatin 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your word.");
        String word = "";
        word = sc.nextLine();
        do
        {
            if(word.length() > 0)
            {
                if(containsVowels(word.substring(0,1)))
                {
                    System.out.println(word+"way");
                }
                else
                {
                    if(containsVowels(word))
                    {
                        System.out.println(word.substring(1,word.length())+word.substring(0,1)+"ay");
                    }
                    else
                        System.out.println("INVALID");
                }
            }
            System.out.println("Enter your word.");
        }
        while(!((word = sc.nextLine()).equalsIgnoreCase("done")));
        sc.close();
    }

    public static boolean containsVowels(String word)
    {
        String[] vowels = {
                "a","e","i","o","u"
        };
        for(int i = 0; i < vowels.length; i++)
        {
            if(word.contains(vowels[i]) ||  word.contains(vowels[i].toUpperCase()))
                return true;
        }
        return false;
    }
}