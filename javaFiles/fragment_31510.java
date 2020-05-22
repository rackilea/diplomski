import java.util.Scanner;
public class cCode {

public static void main(String args[]) {

    System.out.println("Enter country code\nChoices: IND, USA, JPN, NZ, WI");
    Scanner cc = new Scanner(System.in);
    String txt = cc.nextLine();
    switch (txt) {
        case "IND":
            System.out.println(txt + " refers to INDIA");
            break;

        case "USA":
            System.out.println(txt + " refers to UNITED STATES");
            break;

        case "JPN":
            System.out.println(txt + " refers to JAPAN");
            break;

        case "NZ":
            System.out.println(txt + " refers to NEW ZEALAND");
            break;

        case "WI":
            System.out.println(txt + " refers to WEST INDIES");
            break;

        default:
            System.out.println("Invalid choice");
   }
}}