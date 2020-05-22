import java.util.Scanner;

public class ReadNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number: \n");
        int n = sc.nextInt();
        int i = 0;
        int sum = 0;    // Create a sum variable
        while(i <= n){
            System.out.print(i);
            sum+=i;     // Add `i` to sum
            if(i == n){
                System.out.print("=");
                System.out.println(sum); // Display `sum` after loops finish
            }
            else{
                System.out.print("+");
            }
            i++;
        }
    }
}