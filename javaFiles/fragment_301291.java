import  java.util.regex.Pattern;
/**
  <P>{@code java LettersOnlyXmpl}</P>
 **/
public class LettersOnlyXmpl  {
  public static final void main(String[] igno_red)  {
     Pattern pLettersOnly = Pattern.compile("[A-Za-z ]+");
      test(pLettersOnly, "Obama");
      test(pLettersOnly, "Kermit The Frog");
      test(pLettersOnly, "The QuIcK brown FOx JUMPED over the lazy DOg");
      test(pLettersOnly, "23874298374");
  }
   private static final void test(Pattern p_p, String s_name)  {
      System.out.print(s_name + "...");
      if(p_p.matcher(s_name).matches())  {
         System.out.println("Contains only letters and spaces. Good.");
      }  else  {
         System.out.println("ERROR: Must contain letters and spaces only.");
      }
   }
}