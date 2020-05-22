public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        TextFlow text = new TextFlow(
            new Text("Search Everywhere\n"),
            new Text("Project View\n"),
            new Text("Go to File\n")
        );
        text.setTextAlignment(TextAlignment.LEFT);
        FlowPane root = new FlowPane(text);
        root.setAlignment(Pos.CENTER);

        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}