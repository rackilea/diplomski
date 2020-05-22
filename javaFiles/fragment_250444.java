public class Game extends Application {

    static List<Card> cardList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {

        MouseGestures mg = new MouseGestures();

        Group root = new Group();

        for( int i=0; i < 10; i++) {

            Card card = new Card();
            card.relocate( i * 20, i * 10);

            mg.makeDraggable(card);

            cardList.add( card);
        }

        root.getChildren().addAll( cardList);

        Scene scene = new Scene( root, 1600, 900);

        primaryStage.setScene( scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

    // TODO: don't use a static method, I only added for the example 
    public static List<Card> getSelectedCards( Card currentCard) {

        List<Card> selectedCards = new ArrayList<>();

        int i = cardList.indexOf(currentCard);
        for( int j=i + 1; j < cardList.size(); j++) {
            selectedCards.add( cardList.get( j));
        }

        return selectedCards;
    }

}