@SuppressWarnings("serial")
class Card3 extends CardPanel {
    public static final String NAME = "Card 3";

    public Card3(CardUser cardUser) {
        super(cardUser);
        setName(NAME);
        add(new JLabel(NAME, SwingConstants.CENTER));
        // TODO put more components in here
    }

}