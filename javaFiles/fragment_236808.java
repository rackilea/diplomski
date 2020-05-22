import java.util.Scanner;

public class Program10 {

         public static void main(String[] args) {

                System.out.println("Enter a string to decrypt");
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();

              decrypt(input);
    }

      public static void decrypt(String input) {

          char ch;
          String str = "";
          int length = input.length();

         for(int i = 0; i < length ; i++) {

                ch = input.charAt(i);

                   if(ch != '.') {  
                     int val = (int) ch;
                    str = str + (val - 97); 
                  } else {

                     String x = "" + ch;
                     str = str.concat(x);
                }

         }
         System.out.println(str);
}