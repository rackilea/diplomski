import java.util.Random;
public class Words {
   public static void main(String[]args){
      Scanner scan = new Scanner(System.in);
      String words[] = {"Iterate","Petrichor"};
      String input = "";
      do {
         do {
            System.out.println("type *start* to begin");
            input = scan.nextLine();
         } while ( !input.equals("start") );

         String random = (words[new Random().nextInt(words.length)]);
         System.out.println("type *next* to repeat");
         input = scan.nextLine();
      }
   } while ( input.equals("next") );
}