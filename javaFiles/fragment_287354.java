public class Description
{
   private String desc;
   private ArrayList<String> words;

   public Description(String desc) 
    {
        this.desc=desc; 
        this.words=Words.getList();
     }
}