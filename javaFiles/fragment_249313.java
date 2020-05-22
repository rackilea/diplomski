public Card findRightCardWithIndex(int index) throws IllegalArgumentException {
  Card card;
  for(Card c:carddeck) {
    if (c.getIndex() == index) {
      card =  c;
      break;
    }
    if(card != null){ // you shuld make an empty method here
      return card;
    }
    throw new IllegalArgumentException("No card found");
}