import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        // Using Scanner for Getting Input from User
        int a = 0;
        Scanner reader = new Scanner(System.in);
        while (a != 6) {
            System.out.println("\tMAIN MENU:\n" +
                    "\t\t1) Add new member record\n" +
                    "\t\t2) Modify existing member record\n" +
                    "\t\t3) Delete member record\n" +
                    "\t\t4) Display all member records\n" +
                    "\t\t5) Search for a particular member record\n" +
                    "\t\t6) Exit");
            boolean intValid = false;
            while(!intValid) {
                System.out.println("Please enter a valid option (1 - 6).");
                String input = reader.next();
                if (isInteger(input)) {
                    a = Integer.parseInt(input);
                    if (a >= 1 && a <= 6) {
                        intValid = true;
                    }
                }
            }

            System.out.println("You entered integer " + a);

            if (a == 1) {
                AddNewMember anm = new AddNewMember(reader);
                anm.openFile();
                anm.addRecords();
                anm.closeFile();
            }
        }
    }

    private static boolean isInteger(String str) {
        return str.matches("-?\\d+");
    }
}