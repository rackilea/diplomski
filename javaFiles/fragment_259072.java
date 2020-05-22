import java.util.Map;
import java.util.HashMap;
public class Tokenizer
{
  public static void main(String[] args)
  {
    int index = 0; int tokenCount;
    Map<String,Integer> wordCount = new HashMap<String,Integer>();
    String message="The Quick brown fox the";

    StringTokenizer string = new StringTokenizer(message);

    tokenCount = string.countTokens();
    System.out.println("Number of tokens = " + tokenCount);
    while (string.hasMoreTokens()) { 
          String word = string.nextToken();
          Integer count = wordCount.get(word);
          if(count == null) { //this means the word was encountered the first time
          wordCount.put(word, 1);
        }
        else { //word was already encountered we need to increment the count
          wordCount.put(word, count + 1);
        }
     }
    for (String words : wordCount.keySet())
        { System.out.println("Word : " +  word + " has count :" +wordCount.get(word); 
    }
  }
}