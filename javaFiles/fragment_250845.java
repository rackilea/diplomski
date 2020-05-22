public class Game {

    // maybe an IntegerProperty?
    private final StringProperty id = new SimpleStringProperty();
    private final StringProperty saveFileName = new SimpleStringProperty();
    private final ListProperty<String> playerNames = new SimpleListProperty<>(FXCollections.observableArrayList()); 

    public Game(String id, String saveFileName, String... playerNames) {
        setId(id);
        setSaveFileName(saveFileName);
        playerNames.get().setAll(playerNames);
    }

    public StringProperty idProperty() {
        return id ;
    }

    public final String getId() {
        return idProperty().get();
    }

    public final void setId(String id) {
        idProperty().set(id);
    }

    // similarly for saveFileName...

    public ListProperty<String> playerNamesProperty() {
        return playerNames ;
    }

    public final ObservableList<String> getPlayerNames() {
        return playerNamesProperty().get();
    }

    public final void setPlayerNames(ObservableList<String> playerNames) {
        playerNamesProperty().set(playerNames);
    }
}