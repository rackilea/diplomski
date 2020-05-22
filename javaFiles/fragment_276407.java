import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class ReadCustomer {


    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner s = new Scanner(new File("input.txt"))) {
           while (s.hasNextLine()) {
               System.out.println("*******************************");
               String[] tokens = s.nextLine().split(" ");
               System.out.println("cid = " + tokens[1]);
               System.out.println("fName = " + tokens[2]);
               String[] mTokens = Arrays.copyOfRange(tokens, 3, tokens.length - 3);
               StringBuilder sb = new StringBuilder();
               for (String temp : mTokens) {
                   sb.append(temp).append(" ");
               }
               System.out.println("mName = " + sb.toString().trim());
               System.out.println("lName = " + tokens[tokens.length - 3]);
               System.out.println("phone = " + tokens[tokens.length - 2]);
               System.out.println("email = " + tokens[tokens.length - 1]);
               System.out.println("*******************************\n");
           }
       }
   }
}