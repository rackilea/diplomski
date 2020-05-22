import java.util.Scanner;

class Test {
   public static void main(String[] args){
       try (Scanner scanner = new Scanner(System.in)) {
           System.out.println("Enter the number here:");
           while (!scanner.hasNextInt() && scanner.hasNext()) {
               System.out.println("Error");
               // Skip the invalid token
               scanner.next();
           }
           if (scanner.hasNext()) {
               int value = scanner.nextInt();
               System.out.println("You entered: " + value);
           } else {
               System.out.println("You bailed out");
           }
       }
   }
}