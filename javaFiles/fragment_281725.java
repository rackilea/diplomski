public class Main {
    public static void main(String[] args){

         String[] suit = { "Clubs", "Hearts", "Diamonds", "Spades" };
         String[] deck = { "2", "3", "4", "5", "6", "7", "8", "9", "10",
                            "Jack", "Queen", "King", "Aces" };
         int counts[] = new int[4];
         for( int a = 0; a < 7; a++ ){
         int i = (int) ( Math.random() * suit.length );
         int j = (int) ( Math.random() * deck.length );
             //System.out.println( "Suit " + suit[i] + " Deck " + deck[j] );
         System.out.println( suit[i] + " : " + deck[j]);
         counts[i]++;
         }
                System.out.println();
         for (int i =0;i<4;++i){
            System.out.println(suit[i] + " : " + counts[i]);
         }

      }
    }