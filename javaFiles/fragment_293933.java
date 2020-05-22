import java.util.ArrayList;

  public class Test{

       String words = new String("HELLO GOODBYE!");
       ArrayList<Character> sample = new ArrayList<Character>();

       for(int i = 0; i<words.length(); i++){
           sample.add(words.charAt(i));
       }
  }