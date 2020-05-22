import java.util.Scanner;

public class IsItAFactor {

    private void doSomething() {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int possibleFactor;
        int Factor = 0;

        for (possibleFactor = 1; possibleFactor <= n; possibleFactor++) {
            if (n % possibleFactor == 0) {
                possibleFactor = Factor;
            }
        }
   }
}