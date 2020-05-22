private void shuffle() {
      Deck ob = new Deck();
      int x = deck.size() - 1;
      for(int i = 0; i < TIMES_TO_SHUFFLE + 1; i ++){
      int r1 = (int) Math.floor(Math.random() * x);
      int r2 = (int) Math.floor(Math.random() * x);
      ob.swap(r1, r2);
}
    }