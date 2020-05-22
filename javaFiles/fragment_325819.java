import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
public class Task6 {

public static void Main(String[] args) throws IOException {
    Scanner sc = new Scanner (System.in);
    FileReader fr = new FileReader("text.txt");
    BufferedReader br = new BufferedReader(fr);
    int input;
    String term;
    System.out.println("1.Search for a term");
    System.out.println("2.Search for a keyword in the descriptions.");
    System.out.println("3.End");
    input = sc.nextInt();
    boolean found=false;
    if (input == 1) {  // first option
        System.out.println("Choice 1 selected.");
        System.out.println("Please type the term you want to search for.");
        term = sc.next(); 
        do {
            if (line.equalsIgnoreCase(term)) {
                found = true;
                System.out.println("Found "+term);
                System.out.println(br.readLine());
            }  
        } while ((br.readLine()!=null) && (found == false)); // use short circuit  here
        if (!found) { // !found is the same as found == false
        System.out.println("Not Found.");
        }
        br.close();
    } else if (input == 2) { 
        System.out.println("Choice 2 selected.");
        System.out.println("Please type the key term you want to search for.");
        term = sc.next();
        do {
            if (lineTwo.contentEquals(term)) {
                found = true;
                System.out.println("Found "+term);
                System.out.println(line);
                System.out.println(lineTwo);
            } else System.out.println("Not Found");
        } while ((br.readLine()!=null)&(found == false));
        br.close();
    } else System.out.println("Goodbye.");
  }
}