public class CardView extends Pane {

    private final CardController controller ;
    private final Card card ;

    public CardView(Card card) {
        this.card = card ;
        this.controller = new CardController(card);

        // layout, register listeners with card, register event handlers...
    }
}