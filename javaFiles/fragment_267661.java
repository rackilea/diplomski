package problem6;
import java.util.Scanner;
public class Problem6 {

    public static void main(String[] args) {
   int input;
   int min = 0;
   int max = 0;
    Scanner keyboard = new Scanner(System.in);   
    System.out.println("How many numbers do you want to enter?");
    input = keyboard.nextInt();

    int array[] = new int[input]; 

        for (int i = 0 ; i < array.length; i++ ) {
           System.out.println("Enter number: ");
           array[i] = keyboard.nextInt();

            if (array[i] >= max)   
            {   
                max = array[i];  
            } 
            else if (array[i] <= min)   
            {   
                min = array[i];   
            }     
        }   
        System.out.print("\nLargest: " + max);   
        System.out.print("\nSmallest:" + min); 
    }   
}