import java.util.Scanner;

class Tutorial {
    public static void main (String args[]){
         System.out.println("Who goes there?");
         Scanner s = new Scanner(System.in);
         String name = s.next(); // get the token
         if (name.equals("me") || name.equals("Me") ){
            System.out.println("Well, good for you smartass.");
         } else System.out.println("Well good meet");
    }
}