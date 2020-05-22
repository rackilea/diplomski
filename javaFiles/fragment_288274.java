import java.util.*;

/**
 *
 * @author Capt. Jack Sparrow, pirate lord of the seven seas
 */
public class Example {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s1 = new Scanner(System.in);
        int[] x = new int[50];
        int i =0, y;
        do
        {
            System.out.println("Enter new positive integer: ");
             y = s1.nextInt();
             x[i] = y;
             i++;
        }while( y >= 0);
        i--;
        System.out.println("Number of positive integers: "+i);
        System.out.print("In reverse order: ");
        for(int j = i; j >0; j--)
        {
            System.out.print(x[j-1] + " ");
        }
        System.out.println();
    }

}