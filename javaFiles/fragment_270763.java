public class PlayerView extends Pane {

    private final PlayerController controller ;

    private final Player player ;

    private final Map<Card, CardView> cardViewLookup ;

    public PlayerView(Player player) {
        this.player = player ;
        this.controller = new PlayerController(player);

        cardViewLookup = new HashMap<>();
        player.getCards().forEach(this::cardAdded);

        // update card views when player's list of cards changes:
        player.getCards().addListener((Change<? extends Card> c) -> {
            while (c.next())  {
                if (c.wasAdded()) {
                    c.getAddedSubList().forEach(this::cardAdded);
                } else if (c.wasRemoved()) {
                    c.getRemoved().forEach(this::cardRemoved);
                }
            }
        });

        // register event handlers which will invoke methods on controller...

    }

    private final void cardAdded(Card card) {
        CardView cardView = new CardView(card) ;
        cardViewLookup.put(card, cardView);
        getChildren().add(cardView);
    }

    private final void cardRemoved(Card card) {
        getChildren().remove(cardViewLookup.get(card));
        cardViewLookup.remove(card);
    }
}