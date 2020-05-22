import java.text.DecimalFormat;
import java.util.Scanner;
public class Payment
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter gross amount: ");
        double gross = keyboard.nextDouble();
        //double gross = 800; //will work
        double fed = (0.15 * gross);
        double state = (0.035 * gross);
        double soc = (0.0575 * gross);
        double med = (0.0275 * gross);
        double pen = (0.05 * gross);
        double hea = 75;
        double net = (gross - (fed + state + soc + med + pen + hea));
        DecimalFormat currency = new DecimalFormat("$0.00");
        System.out.println("Paycheck calculation by employee\n");
        System.out.printf("Gross Amount: %27s%n", currency.format(gross));
        System.out.printf("Federal Tax:%29s%n", currency.format(fed));
        System.out.printf("State Tax:%31s%n", currency.format(state));
        System.out.printf("Social Security Tax:%21s%n", currency.format(soc));
        System.out.printf("Medicare/Medicaid Tax:%19s%n", currency.format(med));
        System.out.printf("Pension Plan %28s%n", currency.format(pen));
        System.out.printf("Health Insurance %24s%n%n", currency.format(hea));
        System.out.printf("Net Pay:%33s", currency.format(net));
        keyboard.close();
    }
}