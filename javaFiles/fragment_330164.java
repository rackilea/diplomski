public Deck()
{
   cards = new Card[52];

   int index = 0;

   for (int suit = 0; suit <= 3; suit++)
   {
      for (int value = 1; value <= 13; value++)
      {
         cards[index] = new Card(value, suit);
         index++;
      }
   }
}