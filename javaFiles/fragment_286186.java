import java.util.Scanner;

public class StringDecimalPartLength {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        String value = input.nextLine().replace(',', '.');

        try {
            Double.parseDouble(value);

            String[] result = value.split("\\.");

            System.out.print(result[1].length() + " decimal place(s)");
        } catch (NumberFormatException e) {
            System.out.println("The entered value is not a decimal number.");
        }
    }
}