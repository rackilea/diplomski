import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Build a simple UI
        VBox root = new VBox(5);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        // Create a list of Chess pieces
        ObservableList<ChessPiece> chessPieces = FXCollections.observableArrayList();

        // Add a sample Chess piece, a queen in this case
        chessPieces.add(new ChessPiece(
                "Queen",
                new ImageView("sample/listViewImages/queen.png"),
                0
        ));

        // Create the ListView
        ListView<ChessPiece> lvChessPieces = new ListView<>();

        // Setup the CellFactory
        lvChessPieces.setCellFactory(listView -> new ListCell<ChessPiece>() {
            @Override
            protected void updateItem(ChessPiece piece, boolean empty) {
                super.updateItem(piece, empty);

                if (empty) {
                    setGraphic(null);
                } else {

                    // Create a HBox to hold our displayed value
                    HBox hBox = new HBox(5);
                    hBox.setAlignment(Pos.CENTER);

                    // Add the values from our piece to the HBox
                    hBox.getChildren().addAll(
                            piece.getImage(),
                            new Label(piece.getName()),
                            new Label("x " + piece.getCount())
                    );

                    // Set the HBox as the display
                    setGraphic(hBox);
                }
            }
        });

        // Bind our list of pieces to the ListView
        lvChessPieces.setItems(chessPieces);

        // Create a button to add change the Queen count
        Button button = new Button("Add a Queen");
        button.setOnAction(e -> {
            // Get the queen from the list of Chess Pieces. For this sample we only have one piece in our List,
            // but in a real application, you'll need to build a method for retrieving the correct piece.
            ChessPiece queen = chessPieces.get(0);
            queen.setCount(queen.getCount() + 1);

            // Refresh the ListView to show the updated counts
            lvChessPieces.refresh();
        });

        root.getChildren().addAll(lvChessPieces, button);
        primaryStage.setScene(new Scene(root));

        primaryStage.show();
    }
}

/**
 * Defines a Chess piece, including it's name, image, and current count
 */
class ChessPiece {

    private final String name;
    private final ImageView image;
    private int count;

    public ChessPiece(String name, ImageView image, int count) {
        this.name = name;
        this.image = image;
        this.count = count;

        // Resize the image, if necessary
        this.image.setFitHeight(25);
        this.image.setFitWidth(20);

    }

    public String getName() {
        return name;
    }

    public ImageView getImage() {
        return image;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}