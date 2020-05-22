public class Words
{
   private static ArrayList<String> words;
   public static ArrayList<String> getWords() 
   {
      if(words==null) 
        {
          words=new ArrayList<String>();
          //read strings from the file and add them into list
        }
      return words;
    }
}