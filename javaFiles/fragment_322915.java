import java.util.Scanner;
import java.io.InputStream;

public class Largest_String {
    public static void main(String[] args) {
         Scanner input=new Scanner(System.in);
         System.out.println("Please Enter The 10 Strings: ");

         String longest = "";

         for(int i=0; i<10; i++){
            System.out.print("Enter String "+(i+1)+": ");
            String str=input.nextLine();
            if( str.length() > longest.length() )
            {
               longest = str;
            }
        }
        System.out.println("The Largest String is "+ longest);
     }
 }