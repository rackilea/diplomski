import java.io.BufferedReader;  
import java.io.IOException;  
import java.io.InputStreamReader;  
import java.util.Arrays;
public class RemoveVowels{  
    public static void main(String []args) throws IOException
    {  
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));  
        System.out.println("Sample Program to Remove Vowels from a given string \n");  
        System.out.println("Enter a line : ");  
        String s=in.readLine();      
        System.out.println("\n" + "String with Vowels removed : ");  
        String r=removeVowels(s);  
        System.out.println(r);  
    }  
    private static String removeVowels(String s)
    {  
        String finalString="";  
        for(int i=0;i<s.length(); i++) 
        {      
            if(!isVowel(Character.toLowerCase(s.charAt(i))))  
            {  
                finalString=finalString+s.charAt(i);  
            }  
        }  
        finalString= ascending(finalString);
        return finalString;  
    }  
    private static String ascending(String s) 
    {
        char[] asc = s.toCharArray();
        Arrays.sort(asc);
        String sorted = new String(asc);
        return sorted;
    }
    private static boolean isVowel(char c) 
    {  
        String vowels="aeiou";   
        for(int i=0; i<5; i++)  
        {   
            if(c==vowels.charAt(i))  
            return true;  
        }  
        return false;     
    }  
}