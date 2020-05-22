public class Test
{
  static ArrayList<String> words;
  public static void main(String[] args) throws FileNotFoundException
  {
    Scanner s = new Scanner(new File("Blah.txt"));
    words = new ArrayList<String>();
    while(s.hasNext ())
    {
      String token = s.next ();
      if(isAWord(token))
      {
        if(token.contains ("."))
        {
         token =  token.replace (".","");
        }
        if(token.contains (","))
        {
          token = token.replace (",", "");
        }
        //and remove other characters like braces and parenthesis 
        //since the scanner gets tokens like
        // here we are, < "are," would be a token
        //
        words.add(token);
      }

    }

  }

  private static boolean isAWord(String token)
  {
    //check if the token is a word
  }
}