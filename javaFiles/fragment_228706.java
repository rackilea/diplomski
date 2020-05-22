import java.util.*;

public class program1
{
    static Scanner input = new Scanner (System.in);
    public static void main (String [] args) {
        int num = getnum(); 
        System.out.println(separate_number(num));
    }

    public static int getnum() {
        int num;
        do {
            System.out.println("Please enter a five digit number");
            num = input.nextInt();
            if (num < 10000 || num > 99999) {
                System.out.println("The number is not five digits");
            }
        } while (num < 10000 || num > 99999);
        return num;
    }

    public static String separate_number(int num) {
        int digit5, digit4, digit3, digit2, digit1;
        digit5 = num % 10;
        num = num / 10;
        digit4 = num % 10;
        num = num / 10;
        digit3 = num % 10;
        num = num / 10;
        digit2 = num % 10;
        num = num / 10;
        digit1 = num % 10;
        num = num / 10;
        return digit1 + "   " + digit2 + "   " + digit3 + "   " + digit4 + "   " + digit5;
    }
}