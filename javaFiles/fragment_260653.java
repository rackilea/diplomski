public class Card extends StackPane implements Initializable {
    public Card() {
        FXMLLoader loader = new FXMLLoader(getClass().getResouce("card.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (Exception e) {
            throw new IllegalStateException("Could not load fxml", e);
        }
    }

    ...

}