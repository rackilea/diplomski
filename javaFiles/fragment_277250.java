import java.util.Scanner;

public class Demo {


 public static void main (String [] args){

    A a = new A();

    a.getValue();


 }

}

class A {

    public void getValue(){


        Scanner input = new Scanner(System.in);

        System.out.println("Enter number : ");

        int x = input.nextInt();

        System.out.println(x);


        }



    }