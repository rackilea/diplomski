public class TestApp extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Text fileText = new Text("File:");

        TextField fileField = new TextField();
        fileField.setMinWidth(250);
        fileField.setPromptText("Drop file here");
        fileField.setOnDragOver((e) -> {
            if (e.getGestureSource() != fileField && e.getDragboard().hasFiles()) {
                e.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            e.consume();
        });
        fileField.setEditable(false);
        fileField.setOnDragDropped(e -> {
            Dragboard db = e.getDragboard();
            boolean success = false;
            if (db.hasFiles()) {
                fileField.setText(db.getFiles().toString());
                success = true;
            }
            e.setDropCompleted(success);
            e.consume();
        });

        Button clearButton = new Button("Clear");
        clearButton.setOnMouseClicked(e -> fileField.setText(""));

        HBox hboxFile = new HBox();
        hboxFile.setAlignment(Pos.CENTER_LEFT);
        hboxFile.getChildren().addAll(fileText, fileField, clearButton);

        HBox.setMargin(fileText, new Insets(10));
        HBox.setMargin(fileField, new Insets(10, 10, 10, 0));
        HBox.setMargin(clearButton, new Insets(10, 10, 10, 0));

        primaryStage.setScene(new Scene(hboxFile));
        primaryStage.sizeToScene();
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}