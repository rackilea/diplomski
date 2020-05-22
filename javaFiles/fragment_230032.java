import java.util.Scanner;
import java.util.InputMismatchException;
//. . .
Scanner s = new Scanner(System.in);
try {
    System.out.println(average(s.nextInt()));
}catch(InputMismatchException e){System.out.println("Incorrect Form of Input. . .");}