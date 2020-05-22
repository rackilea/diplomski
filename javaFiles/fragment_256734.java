import java.util.Scanner;
class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int failed = 0;

        while (failed < 2) {
            System.out.println("Please enter an number between 0-99: ");
            int n = input.nextInt();
            if ((n > 99) || (n < 1)) {
                System.out.println("Invalid number");
                failed += 1;
            } else {
                System.out.println("Correct! Closing now");
                return;
            }
        }        
        System.out.println("Finished after two failed attempts");
    }
}