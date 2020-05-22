import java.util.Scanner;


public class Main{
private static Scanner input;
     public static void main(String []args){

         input = new Scanner(System.in);

    System.out.print("Enter the first city: ");
    // Prompt user for city
    String city1 = input.nextLine();
    System.out.print("Enter the second city: ");
    // Prompt user for the second city
    String city2 = input.nextLine();

    System.out.print("Enter the latitude and longitude of the first city separated by a space (Ex. 28.8 81.2): ");
    String coord1 = input.nextLine();
    // Save coordinates as a string
    String [] tempArray1 = coord1.split(" ");
    // Split string
    double lat1 = Double.parseDouble(tempArray1[0]);
    double long1 = Double.parseDouble(tempArray1[1]);


    System.out.print("Enter the latitude and longitude of the second city separated by a space (Ex. 28.8 81.2): ");
    String coord2 = input.nextLine();
    // Save coordinates as a string
    String [] tempArray2 = coord2.split(" ");
    // Split string
    double lat2 = Double.parseDouble(tempArray2[0]);
    double long2 = Double.parseDouble(tempArray2[1]);

    double x = (long1 - long2) * 55;
    double y = (lat1 - lat2) * 69;
    double distance = Math.sqrt(x*x+y*y);

    System.out.println("The distance between " + city1 + city2 + " is " + distance + "miles.");




     }
}