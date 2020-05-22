import java.util.Scanner;
public class MyClass{
    public static void main(String[] args){
        int sum = 0;
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()){
            sum += in.nextInt();
        }
    }
}