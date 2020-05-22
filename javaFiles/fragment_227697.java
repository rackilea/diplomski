import java.util.Scanner;
// imports classes;

public class Main_Programm1 
{
  public static void main(String args[]) 
  {
    String something = "something";
    String something2 = "something2";
    Main_Programm main_prog;
    Main_Programm2 main_prog2;

    Scanner userInput = new Scanner(System.in);
    String action = userInput.next();
    if (action.equals(something)) 
    {
      main_prog = new Main_Programm();
      //.....
    } 
    else if (action.equals(something2)) 
    {
      main_prog2 = new Main_Programm2();
      //.....
    }
  }
}