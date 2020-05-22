import java.util.Scanner;
public class test{

    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int a = 1;
        int b = 1;

        while (!(a == 0 || b == 0)){
            System.out.println("");
            a = in.nextInt();
            b = in.nextInt();
        } 
    }
}