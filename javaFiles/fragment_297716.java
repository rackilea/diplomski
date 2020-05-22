import java.util.Scanner;

public class Month {

public static void main(String[] args) {
    int month1;
    int month2;
    Scanner scan = new Scanner(System.in);
    System.out.print("Please enter monthly kWh usage for month 1: ");
month1 = scan.nextInt();

while (month1 > 10000 || month1 < 0) {
    System.out.print(" Please enter a valid amount: ");
    month1 = scan.nextInt();
}

System.out.print("Please enter monthly kWh usage for month 2: ");
month2 = scan.nextInt();

while (month2 > 10000 || month2 < 0) {
    System.out.print(" Please enter a valid amount: ");
    month2 = scan.nextInt();
}
}
}