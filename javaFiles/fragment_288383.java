@Override
    public void start(Stage primaryStage) {
        // Get the pane for the scene
        primaryStage.setScene(new Scene(getPane(), 180, 600));

        // Setup the stage
        primaryStage.setTitle("Elevator Buttons");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    protected Pane getPane() {
        Pane pane = new VBox(10);
        pane.setPadding(new Insets(40));
        GridPane grid = new GridPane();

        for (int i = 0; i < row; i++) {
            for (int k = 0; k < col; k++) {
                // Set the button number as text for the button
                Button button = new Button(Integer.toString((row * col - 2 * i - 1) + k));

                button.setPrefWidth(100);
                button.setStyle("-fx-font: 22 arial; -fx-base: LightGray");

                // Add the button to the pane and set the handler
                grid.add(button, k, i);
                button.setOnAction(buttonHandler);
            }
        }
        return grid;
    }