package deneme23;
import java.util.InputMismatchException;
    import java.util.Scanner;
/**
 *
 * @author davec
 */
public class Deneme23 {



       public static void main(String[] args){
          String [] opts=null;
          Scanner input=new Scanner(System.in);
           double cost= 0.0;
           OUTER:
           while (true) {
               while (true) {
                   System.out.println("Please enter a delivery speed.\nIf you want to see all options of delivery speed, enter 'options'.");
                   try {
                       String line = input.nextLine();
                       opts = line.split("\\s");
                       break;
                   }
                   catch (InputMismatchException e) {
                       System.out.println("Wrong type, pls try again!");
                       input.nextLine();
                   }
               }switch (opts[0]) {
                   case "fast":
                       cost = cost + 34.9;
                       System.out.println("Total is updated to " + cost + "$");
                       break OUTER;
                   case "average":
                       cost = cost + 17.5;
                       System.out.println("Total is updated to " + cost + "$");
                       break OUTER;
                   case "standart":
                       cost = cost + 5.5;
                       System.out.println("Total is updated to " + cost + "$");
                       break OUTER;
                   case "VIP":
                   case "vip":
                   case "Vip":
                       cost = cost + 50;
                       System.out.println("Total is updated to " + cost + "$");
                       break OUTER;
                   case "options":
                       System.out.println("* For VIP delivery speed enter 'VIP'. (costs 50 $) " +
                               "\n* For fast delivery speed enter 'fast'. (costs 34.9 $) " +
                               "\n* For average delivery speed enter 'average' (costs 17.5 $)" +
                               "\n* For standart delivey speed enter 'standart' (costs 5.5 $)");
                       break;
                   default:
                       System.out.println("Wrong type, please read options and be careful with the capital letters.");
                       break;
               }
           }
     }
    }