import java.util.Scanner;

public class input {

    //declaration of your attribute
    public int a;
    public int b;

    //constructor of your class input
    public input(){
    }

    //function to put values in your attribute a and b
    public void readAandB(){
        //You can use scanner to init your values
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a :");
        a = scan.nextInt();
        System.out.print("Enter b :");
        b = scan.nextInt();
    }
}