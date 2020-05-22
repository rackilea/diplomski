import java.util.Scanner;
public class FracCalc {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to FracCalc");
        System.out.println("Type expressions with fractions, and I will evaluate them");

        String answer = scan.nextLine();

        do {

            if (answer.equals("Quit")) {
                System.out.println("Thanks forr running FracCalc!");
                break;  

            } else {
                System.out.println("I can only process 'Quit' for now");
            }

            answer = scan.nextLine();
        } while (true);
    }
}