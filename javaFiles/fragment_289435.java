import java.util.Scanner;

class ProcessPurchasses {
    public static void main(String args[]) {
        Scanner myScanner = new Scanner(System.in);
        Purchase[] aPurchase = new Purchase[3];

        for (int count = 0; count < 3; count++){
            aPurchase[count] = new Purchase();
            aPurchase[count].amount = myScanner.nextDouble();
            aPurchase[count].quantity = myScanner.nextInt();
        }
    }
}