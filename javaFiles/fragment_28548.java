import java.util.Scanner;

public class MeterConversion {

    public static void main(String[] args) {

        int meters;
        System.out.print("Enter meters: ");
        Scanner userInput = new Scanner (System.in);
        meters = userInput.nextInt();

        double inches = (39.370078 * meters);
        int miles = (int) (inches / 63360);
        int feet =  (int) (inches - miles * 63360) / 12;
        double inchesRemaining = inches - (miles*63360 + feet*12);

        System.out.print(meters + " meter(s) converts to " 
        + miles +" mile(s), " + feet + " feet, " 
        + inchesRemaining + " inch(es)");
    }
}