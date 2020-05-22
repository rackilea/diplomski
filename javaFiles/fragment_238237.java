package babynamestatesocial;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BabyNameStateSocial {



private Scanner x;

public static void main(String[] args) throws FileNotFoundException {


    Scanner scan = new Scanner(System.in);
    System.out.println("Available state files are: \n" +
            "AK " + "AL " + "AR " + "AZ " + "CA " + "CO " + "\n" +
            "CT " + "DC " + "DE " + "FL " + "GA " + "HI " + "\n" +
            "IA " + "ID " + "IL " + "IN " + "KS " + "KY " + "\n" +
            "LA " + "MA " + "MD " + "ME " + "MI " + "MN " + "\n" +
            "MO " + "MS " + "MT " + "NC " + "ND " + "NE " + "\n" +
            "NH " + "NJ " + "NM " + "NV " + "NY " + "OH " + "\n" +
            "OK " + "OR " + "PA " + "RI " + "SC " + "SD " + "\n" +
            "TN " + "TX " + "UT " + "VA " + "VT " + "WA " + "\n" +
            "WI " + "WV " + "WY " + "\n");
    System.out.print("Enter a state to read names from: " + "\n");
    String filename = scan.nextLine() + ".txt";
    System.out.println("Which name would you like to look up?");
    String personName = scan.nextLine();

    File myFile = new File(filename);

    openFile(myFile,personName);

}

private static void openFile(File myFile, String personName){
    try {
        Scanner sc = new Scanner(myFile);
        while (sc.hasNext()) {
            String nextLine = sc.nextLine();
            if (nextLine.contains(personName)) {
                //nextLine variable now has the line from the file in it that matches the name the person input so you need to parse that line and do something with it
            }
        }
    } catch(Exception e) {
        System.out.print(e.getMessage());
    }
}

}