public class GoFishPlayer {
  private Deck deck;

  public GoFishPlayer(Deck deck) { this.deck = deck; }
  ...
}

public class StartGame {
  public static void start(){
    Deck deck = new Deck(1);
    GoFishHumanPlayer player = new GoFishHumanPlayer(deck);
    GoFishAiPlayer ai = new GoFishAiPlayer(deck);
    player.drawHand();
    ai.drawHand();
    player.turn();
  }
}