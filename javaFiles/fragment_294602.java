enum Suit {
   SPADES(false),
   HEARTS(true),
   DIAMONDS(true),
   CLUBS(false);

   private final boolean red;

   private Suit(boolean red) {
     this.red = red;
   }

   public boolean isRed() {
     return red;
   }
}