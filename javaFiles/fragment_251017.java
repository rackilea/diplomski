import java.util.Scanner;
public class Solution {
    public static void main(String[] args) [
        Scanner s=new Scanner(System.in);
        int carCapacity=5;

        System.out.println("How many students?");
        int students=s.nextInt();
        int cars=students/carCapacity;
        int leftOver=students%carCapacity;

        System.out.println("Cars needed: "+cars);
        System.out.println("Students left over: "+leftOver);


    }
}