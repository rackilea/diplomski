import java.util.Scanner;

public class Radical {

public static void main(String[] args) {

    System.out.print("Enter the unsimplified radical: ");
    Scanner scan = new Scanner(System.in);
    int input = scan.nextInt();

    recurse(input);

}

public static void recurse(int x) {

    System.out.println("Attempting to simplify -/" + x);

    int a = 0;
    int b = 0;
    int count = 0;

    for (int i = 1; i < x; i++) {
        if ((i * (x/i)) == x) {
            //System.out.println(i + "<i rest>" + (x/i));
            a = i;
            b = x/i;
            if (Math.sqrt(a)%1==0) {
                if (a != 1) {
                System.out.println((int)Math.sqrt(a) + "-/" + b);
                count = 1;
                }
            }
        }
    }

    if (count>0) {
        recurse(b);
    } else if (count==0) {
        System.out.println("Cannot simplify -/" + x);
    }

}

}