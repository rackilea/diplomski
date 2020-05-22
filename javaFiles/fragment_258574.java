public class ProgressExample extends Application {

    public StackPane layout, main, progress;

    public StackPane createProgressPane() {
        ProgressIndicator indicator = new ProgressIndicator();
        indicator.setMaxHeight(50);
        indicator.setMaxWidth(50);

        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setStyle("-fx-background-color: rgba(160,160,160,0.7)");
        pane.getChildren().add(indicator);

        Task<Void> task = new Task<Void>(){
            protected Void call() throws Exception {
                // Your process here.
                // Any changes to UI components must be inside Platform.runLater() or else it will hang.
                Thread.sleep(2000);

                Platform.runLater(() -> {
                    layout.getChildren().remove(pane);
                });
                return null;
            }
        };
        new Thread(task).start();
        return pane;
    }

    public StackPane createMainPane() {
        Label label = new Label("Hello World!");
        label.setFont(Font.font("Tahoma", FontWeight.SEMI_BOLD, 16));

        Button start = new Button("Start Process");
        start.setOnAction(action -> {
            progress = createProgressPane();
            layout.getChildren().add(progress);
        });

        VBox vbox = new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(label, start);
        vbox.setPadding(new Insets(10,10,10,10));

        StackPane pane = new StackPane();
        pane.getChildren().add(vbox);
        return pane;
    }

    public void start(Stage stage) throws Exception {
        main = createMainPane();

        layout = new StackPane();
        layout.getChildren().add(main);

        Scene scene = new Scene(layout, 900, 550);
        stage.setScene(scene);
        stage.setTitle("Progress Example");
        stage.setOnCloseRequest(e -> {
            Platform.exit();
            System.exit(0);
        });
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}