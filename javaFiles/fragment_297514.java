public class TestClass {


 static Scanner in = new Scanner(System.in);
public static void main(String args[])
{
String antonio = "0";
String answer;

System.out.print("Whats your name? ");
answer = in.nextLine();
if (answer .equalsIgnoreCase(antonio) ) {
System.out.println("are you sure? you are a Dank Meme "+answer);
}
else
{
 System.out.println("Damn, you aren't a Dank Meme "+answer);
}
}

}