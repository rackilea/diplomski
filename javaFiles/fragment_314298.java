public void shuffle()
{ // replace 51 with any arbitrary number
  for (int i = 0; i <= 51; i++) {
    // two cards to swap
    int j = (int)Math.floor(Math.random() * 52);
    int k = (int)Math.floor(Math.random() * 52);

    // swap cards
    Card temp = card[j];
    card[j] = card[k];
    card[k] = temp;
  }
}