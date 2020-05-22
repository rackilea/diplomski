public class pack
{
    String[] values = {"0", "A", "2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K"};
    String[] suits = {"Hearts", "Spades", "Diamonds", "Clubs"}; 

    public static void main(String[] args) {
        card[] deck = new card[52]; 

        for (int i = 1; i < 14; i++)
        {
            for (int j = 0; j<4; j++)
            {
                deck[j*13 + i] = new card(suits[j], values[i]);
            }
        }
    }
}