import java.util.Scanner;

public class aps{
public static void main(String [] args){ 

    //Declaring variables
    int length, width;

    //Prompting user for length
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the length of your rectangle: ");
    length = scanner.nextInt();// integer i for rows(width)

    //Prompting user for width
    System.out.print("Enter the width of your rectangle: ");
    width = scanner.nextInt();//integer j for columns(length)

    //Processing
    for(int i = 0; i<width; i++){  //first loop
        for(int j = 0; j<length; j++){ //second loop
            if(i==0||j==0||j==length-1||i==width-1){
                System.out.print("*");
            }
            else{
                System.out.print(" ");
            }

        }// end of second loop

        System.out.println();

    } //end of first loop


    }
}