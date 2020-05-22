import java.util.Scanner;

public class isbn {

    public static boolean validISBN(String isbnNumber) {
        isbnNumber = isbnNumber.replace("-", "").trim();
        if (isbnNumber.length() == 10 && isbnNumber.matches("[0-9]+")) {
            int sum = 0;
            for (int i = 10; i > 0; i--) {
                if (isbnNumber.charAt(9) == 'X' && i == 1) {
                    sum += i * 10;
                } else {
                    sum += i * Character.getNumericValue(isbnNumber.charAt(10 - i));
                }
            }
            if (sum % 11 == 0) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String isbnNumber;
        do {
            System.out.print("Input ISBN Number: ");
            isbnNumber = keyboard.next();
            validISBN(isbnNumber);
            if ("q".equalsIgnoreCase(isbnNumber)) {
                break;
            }
        } while (true);
    }
}