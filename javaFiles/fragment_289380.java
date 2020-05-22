import java.util.Scanner;

public class TimeAssignment {

public static void main(String[] args){
    Scanner input = new Scanner(System.in);

    final double minConv = 0.0166667;
    final double hourConv = 60;

    int hours;
    System.out.print("Enter the hours to convert:");
    hours = input.nextInt();

    int minutes;
    System.out.print("Enter the minutes to convert:");
    minutes = input.nextInt();

    System.out.println("Total minutes: "+((hours * 60)+minutes));    

   }
 }