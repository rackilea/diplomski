package labsheet1;

import java.util.Scanner;

public class Ques5 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner input = new Scanner(System.in);

        int num1;
        int num2;
        int add,sub,mul,div;
        int onum;
        String ans = "Yes";

        do
        {
            System.out.print("Enter first number :");
            num1=input.nextInt();
            System.out.print("Enter second number :");
            num2=input.nextInt();
            System.out.print("Enter operation number :");
            onum=input.nextInt();

            add=num1+num2;
            sub=num1-num2;
            mul=num1*num2;
            div=num1/num2;

            switch(onum)
            {
               case 1:
                 System.out.println("Addition(+)");
                 System.out.println("The result is " +add);

                 break;
               case 2:
                  System.out.println("Subtraction(-)");
                  System.out.println("The result is " +sub);
                  break;
               case 3:
                  System.out.println("Multiplication(*)");
                  System.out.println("The result is " +mul);
                  break;
               case 4:
                  System.out.println("Division(/");
                  System.out.println("The result is " +div);
                  break;
               default:
                   System.out.println("None of the operations");
            }
            System.out.print("Do you want to make another calculation?");
            ans=input.nextLine();
         }while(ans.toLowerCase().equals("Yes"));
    }