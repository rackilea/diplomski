public int compareTo(Card anotherCard) {
  if (this.suit.equals(anotherCard.suit) && this.rank.equals(anotherCard.rank)) {
    return 0;
  }
  else if (this.suit.equals(anotherCard.suit)) {
    return this.rank.compareTo(anotherCard.rank);
  }
  else {
    return this.suit.compareTo(anotherCard.suit);
  }
}