public class CardGUI() {
    public static void main(String[] args) {
        // create your GUI and put your logic here...
        // also use your other classes, perhaps like so.
        Card card = new Card("One", 1);
        CardManager cardManager = new CardManager();
        cardManager.addCard(card);

        // From there you can manage your cards through other classes.
}