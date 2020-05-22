import java.util.Scanner;

public class ReadAndStoreNames {

public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);

    System.out.println("How many names would you like to enter?")
    int n = scan.nextInt(); //Ensures you take an integer
    System.out.println("Enter the " + n + " names: ");

    String [] names = new String[n];
    //store the names in an array
    for (int i = 0; i < names.length; i++){
        names[i] = scan.nextLine();
        }
    //sequentially print the names and upperCase them
    for (String i : names){
        System.out.println(i.toUpperCase());
        }

    scan.close();

}

}