import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Time {
public static void main(String args[]) throws ParseException{
Scanner input = new Scanner(System.in);
 System.out.print("Enter first time (hh:mm aa): ");
 String time = input.nextLine();
 System.out.println();
 System.out.print("Enter second time (hh:mm aa): ");
 String time2 = input.nextLine();
 System.out.println();
 DateFormat sdf = new SimpleDateFormat("hh:mm aa");
 Date d1 = sdf.parse(time);
 Date d2 = sdf.parse(time2);

 System.out.println("Time: " + sdf.format(d1));
 System.out.println("Time: " + sdf.format(d2));
    if(d1.after(d2)){
     long diffMs = d1.getTime() - d2.getTime();
     long diffSec = diffMs / 1000;
     long min = diffSec / 60;
     long sec = diffSec % 60;
     System.out.println("The difference is "+min+" minutes and "+sec+" seconds.");
    }

    if(d1.before(d2)){
     long diffMs = d2.getTime() - d1.getTime();
     long diffSec = diffMs / 1000;
     long min = diffSec / 60;
     long sec = diffSec % 60;
     System.out.println("The difference is "+min+" minutes and "+sec+" seconds.");
    }

    if(d1.equals(d2)){
     System.out.println("The difference is 0 minutes and 0 seconds.");
    }

 }
}