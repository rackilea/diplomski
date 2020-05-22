import java.text.DecimalFormat;
import java.util.Scanner;

public class TempConverter {

    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#,###.0");
        System.out.println("Temperature Converter");
        System.out.println("---------------------");
        System.out.println();
        Scanner input = new Scanner(System.in);

        System.out.print("How many conversions would you like to make: ");
        int conversions = input.nextInt();

        for (int i = 1; i <= conversions; i++) {
            System.out.println("Conversion # " + i);
            System.out.println();
            System.out.println("To convert from celsius to fahrenheit type 1 ");
            System.out.print("To convert from fahrenheit to celsius type 2: ");
            int choice = input.nextInt();
            switch (choice) {
            case 1:
                System.out.println();
                System.out.print("Enter a celsius temperature: ");
                double cels = input.nextDouble();
                double result = celsiusToFahrenheit(choice, cels);
                System.out.println();
                System.out.println("The conversion of " + cels + " from celcius to fahrenheit is " + df.format(result));
                break;
            case 2:
                System.out.println();
                System.out.print("Enter a farenheight temperature: ");
                double fahr = input.nextDouble();
                double result1 = fahrenheitToCelsius(choice, fahr);
                System.out
                        .println("The conversion of " + fahr + " from fahrenheit to celcius is " + df.format(result1));
                break;
            }
        }
    }

    public static double celsiusToFahrenheit(int choice, double cels) {

        double converted = 0.0;
        if (choice == 1)
            converted = 9.0 / 5.0 * cels + 32;

        return converted;
    }

    public static double fahrenheitToCelsius(int choice, double fahr) {
        double converted2 = 0.0;
        if (choice == 2)
            converted2 = 5.0 / 9.0 * (fahr - 32);

        return converted2;
    }

}