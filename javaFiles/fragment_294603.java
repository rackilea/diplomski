enum Suit {
   SPADES,
   HEARTS,
   DIAMONDS,
   CLUBS;

   public boolean isRed() {
     return this == HEARTS || this == DIAMONDS;
   }
}