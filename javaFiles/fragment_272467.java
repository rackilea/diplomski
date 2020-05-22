import java.util.Scanner;

class Test {
    public static void main(String[] args) {
        System.out.printf("Please enter a maximun integer value: ");
        Scanner scan = new Scanner(System.in);
        double n = scan.nextDouble();

        System.out.printf("The number you entered was: %.0f \n", n); // Just to check if user input is correct

        double startNum = 0;
        double sqrt = startNum;

        System.out.printf("Squares less than %.0f are: ", n);
        while (sqrt < n) {
            sqrt = Math.pow(startNum, 2);
            if(startNum != 0 && startNum % 10 == 0) {
                System.out.println();
            }
            System.out.printf("%6.0f", sqrt);
            startNum++;
        }
    }
}