import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args){

        int[] array=new int[100];
        Scanner in=new Scanner(System.in);

        System.out.println("Enter your number elements: ");
        int n_Elements=in.nextInt();

        System.out.println("Enter your number now: ");

        for(int i=0; i<n_Elements; i++){
            array[i]=in.nextInt();
        }
        for(int i = 0; i<n_Elements; i++){ //you need to loop to get all the values in an array

        System.out.print(array[i]);
    }
}