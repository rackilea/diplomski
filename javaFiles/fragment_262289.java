public class RegexDemo {

public static void main(String [] args)
{
    String text1 ="ghhthyuj";
    String text2 ="G$hthyu5";
    System.out.println(text1.matches("^(?=.{8,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*/&%^*$#@!~+_]).+$"));
    System.out.println(text2.matches("^(?=.{8,})(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[*/&%^*$#@!~+_]).+$"));
}