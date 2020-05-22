public class TouchApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        JPanel swingContent = new JPanel();
        swingContent.add(new JButton("Hello world"));
        swingContent.add(new JScrollBar());

        BorderPane content = new BorderPane();
        SwingNode swingNode = new SwingNode();
        swingNode.setContent(swingContent);
        content.setCenter(swingNode);
        Scene scene = new Scene(content);
        scene.setOnTouchPressed((e) -> {
            System.out.println(e);
        });
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}