public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Button button[][] = new Button[10][10];
        int rows, columns, gridSize;

        GridPane tileGrid = new GridPane();

        for (rows = 0; rows < 10; rows++) {
            for (columns = 0; columns < 10; columns++) {
                button[rows][columns] = new Button();
                button[rows][columns].setStyle("-fx-background-color: red");
                button[rows][columns].setPrefSize(50, 50);

                //button[rows][columns].setOnMouseClicked(new clickEvents(rows, columns));
                //no setters, directly passed rows and cols to clickEvents Class

                tileGrid.add(
                        button[rows][columns],   // Specific node in the array
                        columns,                 // Set the specific column
                        rows                     // Set the specific row
                ); //adds buttons to the tile grid
            }
        }

        ScrollPane scrollPane = new ScrollPane(new VBox(tileGrid));

        primaryStage.setScene(new Scene(scrollPane));
        primaryStage.show();
    }
}