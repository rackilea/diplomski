package CatchBlock;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Moe
 */
public class catchblock {
     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        boolean invalid = true;
        Scanner Pad = new Scanner(System.in);
        int i1 = 0, i2 = 0;
        double r = 0;
        while(invalid)
        {
            try{
                System.out.print("Enter first Integer: ");
                i1 = Pad.nextInt();
                System.out.print("Enter second integer: ");
                i2 = Pad.nextInt();
                if(i2 == 0)
                    throw new DevideByZerooException("Cannot divide by Zero");
                r = (double) i1/i2;
                invalid = false;
            }
            catch(InputMismatchException e) {
                Pad.nextLine();
                System.out.println("Please enter a number.");
            }
            catch(DevideByZerooException e)
            {
                Pad.nextLine();
                System.out.println(e.getMessage());
            }
        }
        System.out.println(i1 + " divided by " + i2 + " is " + r + ".");
    }
}