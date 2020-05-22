public enum CardColour {
  RED, BLACK
}

public enum Suit {
  SPADES(CardColour.BLACK),
  CLUBS(CardColour.BLACK),
  HEARTS(CardColour.RED),
  DIAMONDS(CardColour.RED);

  private final CardColour colour;

  Suit(CardColour colour) { this.colour = colour; }

  public CardColour getColour() { return colour; }
}