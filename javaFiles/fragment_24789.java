import java.util.Scanner;
public class HelloWorld{

 public static void main(String []args){
    System.out.println("Hello World");
    int halfSize;
    int p = 0;
    String message;
    System.out.println("Please enter a string: ");
    Scanner input = new Scanner(System.in);

    message = input.nextLine();
    halfSize = 2 * message.length() - 1;

     for (int i = 1; i <= message.length(); i++) {
         int pre_post_blank = (2 * halfSize) - ( 2 * i -1);

          for (int k = 0; k < pre_post_blank / 2; k++)
            System.out.print(" ");


          for(int j = 0; j < i;j++ )
          {
              System.out.print(message.charAt(j));
              System.out.print(" ");
          }



          for (int k = 0; k < pre_post_blank / 2; k++)
            System.out.print(" ");

          System.out.print("\n");
       }
       for (int i = message.length(); i >= 1; i--) {
         int pre_post_blank = (2 * halfSize) - ( 2 * i -1);

          for (int k = 0; k < pre_post_blank / 2; k++)
            System.out.print(" ");


          for(int j = 0; j < i;j++ )
          {
              System.out.print(message.charAt(j));
              System.out.print(" ");
          }



          for (int k = 0; k < pre_post_blank / 2; k++)
            System.out.print(" ");

          System.out.print("\n");
       }

   }
 }