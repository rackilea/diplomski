import java.util.*;

public class a
{
  public static void main (String [] args) throws Exception
  {
    Scanner sc = new Scanner(System.in);

    List<String> words = new ArrayList<String>();

    while(words.size () < 3 && sc.hasNextLine ()) {
        String s = sc.nextLine();
        System.out.println ("Adding " + s);
        words.add(s);
    }

    String[] wordsarray = words.toArray(new String [] {});

    for(int i = 0; i < words.size(); i++) {
       System.out.println("Printing ..." + wordsarray[i]);
    }
  }
}