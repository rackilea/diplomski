public class GameState {

    private ObservableList<SubGame> currentGames = FXCollections.observableArrayList();

    public ObservableList<SubGame> getCurrentGames() {
        return currentGames();
    }

    private ReadOnlyObjectWrapper<SubGame> currentGame = new ReadOnlyObjectProperty<>();

    public ReadOnlyObjectProperty<SubGame> currentGameProperty() {
        return currentGame.getReadOnlyProperty() ;
    }

    public final SubGame getCurrentGame() {
        return currentGameProperty().get();
    }

    public GameState() {
        // initialize sub game list...
    }

    public void nextGame() {
        int index = currentGames.indexOf(currentGame.get());
        if (index < currentGames.size() - 1) {
            currentGame.set(currentGames.get(index + 1));
        }
    }

    public void start() {
        currentGame.set(currentGames().get(0));
    }

    public boolean hasMoreGames() {
        return currentGames.indexOf(currentGame.get()) < currentGames.size() - 1 ;
    }
}