import java.util.*;

public class Lab4Exercise1{
public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    double password;
    double reentered;
    do {
        System.out.println("(Re)Enter Password:");
        password = sc.nextDouble();
        System.out.println("Confirm Password:");
        reentered = sc.nextDouble();
    } while (password != reentered);

    }
}