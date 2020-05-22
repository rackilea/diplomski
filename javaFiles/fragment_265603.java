import java.util.Scanner; 
public class Burger { 
        static Scanner console = new Scanner (System.in); 
        public static void main(String args []) {

             double payweek;
             int hours;
             double monthPay = 0;
             for( int w = 1; w < 5; w++;){
                     System.out.print("How many hours did you work in week" +w+"?");hours = console.nextInt();
                     payweek =  0.7*5.15*hours;
                     monthPay = monthPay + payweek;
                     System.out.println("Your take home pay is $" + payweek);
           }
           System.out.println("Your total pay for the month is "+monthPay);
       }
    }