/**
   <P>{@code java MyHomeworkMainClass}</P>
 **/
public class MyHomeworkMainClass  {
   public static final void main(String[] ignored)  {
      System.out.println("Visit.isUserInputYesNo(null)=" + Visit.isUserInputYesNo(null));
      System.out.println("Visit.isUserInputYesNo(\"gibberish\")=" + Visit.isUserInputYesNo("gibberish"));
      System.out.println("Visit.isUserInputYesNo(\"yes\")=" + Visit.isUserInputYesNo("yes"));
      System.out.println("Visit.isUserInputYesNo(\"no\")=" + Visit.isUserInputYesNo("no"));
   }
}
 class Visit  {
   public static final boolean isUserInputYesNo(String input)  {
      return  (input != null  &&
         (input.equals("yes")  ||  input.equals("no")));
   }
}