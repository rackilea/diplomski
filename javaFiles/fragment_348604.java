public class NestedLoopPattern {
     public static void main(String[] args) {
         final int HASHTAG_AMMOUNT = 6;

         for (int i=0; i < HASHTAG_AMMOUNT; i++) {
             // don't print a newline here, just print a hash
             System.out.print("#");
             for (int j=0; j < i; j++) {
                 System.out.print(" ");
             }
             System.out.println("#");
         }
     }
}