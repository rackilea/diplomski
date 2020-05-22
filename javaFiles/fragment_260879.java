import java.util.*;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a number and press [Enter] per line, when you no longer wish to continue press [Enter] with no input.");
        String str = scanner.nextLine();
        int x = 0;

        try {
            while(!str.isEmpty()){
                int number = Integer.parseInt(str);

                if (number > x){
                    x = number;
                }

                str = scanner.nextLine();
            }
        }
         catch (NumberFormatException e) {
             System.out.println("There was an exception. You entered a data type other than Integer");
         }

        System.out.println("Largets number entered: " + x);

    }
}