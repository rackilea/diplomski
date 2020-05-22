enum Suit {
   SPADES {
     @Override public boolean isRed() { return false; }
   },
   HEARTS,
     @Override public boolean isRed() { return true; }
   },
   DIAMONDS,
     @Override public boolean isRed() { return true; }
   },
   CLUBS {
     @Override public boolean isRed() { return false; }
   };

   public abstract boolean isRed();
}