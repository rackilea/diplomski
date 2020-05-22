import java.util.Scanner;

public class Test {
   public static void main (String[] args) {
       Scanner in = new Scanner(System.in);
       boolean flag = true;
       while(flag == true){
           System.out.println("Type in 'c', 'a', 'm', 'e', 'p' or 'b'");
           String sign = in.next();
           char ch = sign.charAt(0);
           System.out.println("Enter the quantity");
           int amount = in.nextInt();
           if(ch == 'c'){
           }else if(ch == 'a'){
           }else if(ch == 'm'){
           }else if(ch == 'e'){
           }else if(ch == 'p'){
           }
           if(ch == 'b'){
               flag = false;
           }
       }
       System.out.println("Done.");
   }
}