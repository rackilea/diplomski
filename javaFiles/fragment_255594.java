import java.util.Scanner;
public class tableintegers {

    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);

        System.out.print("Enter the number of rows:");
        int rows=input.nextInt();
        System.out.print("Enter the number of columns:");
        int cols=input.nextInt();

        int total=0, sumOfRow=0, numbers=0;
        for(int i=0; i<rows; i++) {
            sumOfRow = 0;
            System.out.println("\nRow No. " + (i + 1) );
            for(int j=0; j<cols; j++) {
                System.out.print("Enter value for Column " + (j+1) + ": ");
                numbers = input.nextInt();
                sumOfRow += numbers;
            }
            System.out.println("Sum of Row No. " + (i+1) + " Values: " + sumOfRow);
            total += sumOfRow;
        }
        System.out.println("\nThe grand total is: " +total);

    }

}