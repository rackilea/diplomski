import  java.util.Scanner;
public class Work6{

   public static void main (String[] args){
    int x;
    int y;
    Scanner in = new Scanner(System.in);
    System.out.println("Number 1:  ");
    x = in.nextInt();
    in.nextLine();
    System.out.println("Number 2: ");
    y = in.nextInt();
    in.nextLine();

 if (x > y){
        System.out.println("Bigger number: " + x);`

    }
    else if (y > x){
        System.out.println("Bigger number: " + y);
    }
}

}