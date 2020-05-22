import java.util.Scanner;
public class Task4 {

    /**
* @param args the command line arguments
*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("Enter an integer N: ");
        int N = in.nextInt();
        boolean unique = false;
        int i = 1;
        while (((i*i)+i) <= N)
        {
            if ((i*i)+i != N) {
                i++;
            } else {
                unique = true;
                break;
            }
        }    
        if (unique)
        {
            System.out.printf("%d is unique.\n",N);

        }
        else 
        {
            System.out.printf("%d is not unique.\n", N);
        }
    }
}