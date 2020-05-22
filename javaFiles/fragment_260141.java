import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dummy{
   public static void main(String []args){
      String password = "aaaZZZ111";
      String specials = "!@#$%^*()_+~`={}|:;\"',.?\\[\\]\\/-";
      String uppercase = "A-Z";
      String lowercase = "a-z";
      String numbers = "\\d";
      String all = specials + uppercase + lowercase + numbers;
      int min = 8;
      int max = 32;

      String regex =
         "^" + lookahead(specials) +  lookahead(uppercase) + lookahead(lowercase) + "[" + all + "]{"+ min +"," + max + "}$|" +
         "^" + lookahead(specials) +  lookahead(uppercase) + lookahead(numbers) + "[" + all + "]{"+ min +"," + max + "}$|" +
         "^" + lookahead(specials) +  lookahead(lowercase) + lookahead(numbers) + "[" + all + "]{"+ min +"," + max + "}$|" +
         "^" + lookahead(uppercase) + lookahead(lowercase) + lookahead(numbers) + "[" + all + "]{"+ min +"," + max + "}$";

      Pattern r = Pattern.compile(regex);

      Matcher m = r.matcher(password);
      if (m.find()) {
         System.out.println("OK");
      } else {
         System.out.println("NO MATCH");
      }
   }

   public static String lookahead(String input) {
      return "(?=.*[" + input + "].*)";
   }
}