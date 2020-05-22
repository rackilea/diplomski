import javafx.application.Application;
import javafx.beans.property.*;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class PlayerViewer extends Application {

    private final ObservableList<Player> data =
        FXCollections.observableArrayList(
            new Player("Jacob", true),
            new Player("Isabella", false),
            new Player("Ethan", true)
        );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        TableView<Player> table = new TableView<>(data);
        table.setPrefHeight(130);
        table.setPrefWidth(150);

        TableColumn<Player, String> handleCol = new TableColumn<>("Handle");
        handleCol.setCellValueFactory(new PropertyValueFactory<>("handle"));
        table.getColumns().add(handleCol);

        TableColumn<Player, Boolean> playingCol = new TableColumn<>("Playing");
        playingCol.setCellValueFactory(new PropertyValueFactory<>("playing"));
        playingCol.setCellFactory(param -> new TableCell<>() {
            RadioButton indicator = new RadioButton();

            {
                indicator.setDisable(true);
                indicator.setStyle("-fx-opacity: 1");
                setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
            }

            @Override
            protected void updateItem(Boolean isPlaying, boolean empty) {
                super.updateItem(isPlaying, empty);

                if (empty || isPlaying == null) {
                    setGraphic(null);
                } else {
                    indicator.setSelected(isPlaying);
                    setGraphic(indicator);
                }
            }
        });
        table.getColumns().add(playingCol);

        stage.setScene(new Scene(table));
        stage.show();
    }

    public static class Player {
        private final SimpleStringProperty handle;
        private final SimpleBooleanProperty playing;

        private Player(String handle, boolean playing) {
            this.handle = new SimpleStringProperty(handle);
            this.playing = new SimpleBooleanProperty(playing);
        }

        public SimpleStringProperty handleProperty() {
            return handle;
        }
        public String getHandle() {
            return handle.get();
        }
        public void setHandle(String handle) {
            this.handle.set(handle);
        }

        public SimpleBooleanProperty playingProperty() {
            return playing;
        }
        public boolean isPlaying() {
            return playing.get();
        }
        public void setPlaying(boolean playing) {
            this.playing.set(playing);
        }
    }
}