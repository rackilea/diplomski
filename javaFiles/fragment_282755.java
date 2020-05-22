public static Suit determineSuit(){
  int randNum = (int) (Math.random() * 4);
  if (randNum == 0){
    return Suit.CLUBS;
  }
  else if (randNum == 1){
    return Suit.DIAMONDS;
  } 
  else if (randNum == 2){
    return Suit.HEARTS;
  }
  else{
    return Suit.SPADES;
  }
}