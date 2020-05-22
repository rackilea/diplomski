import java.util.*;
public class SchoolHomework {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Program that converts decimal to binary!");
        int dec;
        System.out.println("Please type in a decimal number:");
        Scanner input = new Scanner(System.in);
        Stack<Integer> todec = new Stack<Integer>();
        dec = input.nextInt();
        if (dec < 0){
            System.out.println("Error: Please enter a positive number!");
            System.exit(0);
        }
        int size = 0;

        while (dec != 0){
            int stackv = dec % 2;
            todec.push(stackv);
            dec /= 2;
            size++;
        }
        if (size % 4 > 0) {
            for(int i = 0; i < 4 - (size % 4); i++) {
               todec.push(0);
            }
        }
        System.out.println(dec + " To binary is: ");
        int counter = 0;
        while (!(todec.isEmpty() )) {
            String val = todec.pop().toString();
            System.out.print(val);
            counter = counter + 1;
            if (counter >= 4){
                counter = 0;
                System.out.print(" ");
            }

        }
    }
}