public class ZoneList<T extends Card> {
   protected List<T> cardBox;
}

public class PokerHand extends ZoneList<PokerCard> {
   public PokerHand() {
      cardBox = new ArrayList<PokerCard>();
   }
}