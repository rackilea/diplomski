import java.util.Scanner;
public class calculator {

int x;
int y;

public void setnumber (){
    Scanner sc = new Scanner (System.in);
    System.out.println("Please Enter X");
    x = sc.nextInt ();
    System.out.println("Please Enter Y");
    y = sc.nextInt ();
}

public void sum (){
    int sum = x + y;
    System.out.println ("The Sum" + sum);
}

public static void main(String[] args) {

    calculator sx = new calculator ();
    sx.setnumber ();
    sx.sum();
}
}