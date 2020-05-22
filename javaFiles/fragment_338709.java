import java.util.Scanner;
public class One {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x;
        int y;
        System.out.print("Enter a number from 10 to 99: ");
        x = input.nextInt();        
        if (x >= 10 && x <= 99) {
            y = x % 10;
            x = x/10 ;
        if(x* y== x+ y)){
            System.out.println("Sum and product are equal" );
        }
        else
            System.out.println("Sum and product are not equal" );

        } else {
            System.out.println("you must enter a number from 10 to 99");
        }
      input.close();
    }
}