import java.util.Arrays;

public class Fill
{
   public static void main(String[] args)
   {
      String[] letters = new String[26];
      for (char ch = 'a'; ch <= 'z'; ch++)
      {
         letters[ch - 'a'] = String.valueOf(ch);
      }
      System.out.println(Arrays.toString(letters));
   }
}