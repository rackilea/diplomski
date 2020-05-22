import java.util.*;
public class Test
{
  public static void main(String[] args)
{
  Scanner keyboard = new Scanner(System.in);
  System.out.print("Enter the duration of the event in seconds: ");
  int duration = keyboard.nextInt();

    int days;
    int hours;
    int minutes;
    int seconds;

    days = duration / 86400;
    hours = duration % 86400 / 3600;
    minutes = duration % 86400 % 3600 / 60;
    seconds = duration % 86400 % 3600 % 60;
    System.out.println("The event lasts "+days+" days "+hours+" hours "+minutes+" minutes and "+seconds+" seconds");
}
}