@Override
public void start(Stage primaryStage) throws Exception {

    BorderPane root = new BorderPane();

    TextArea textArea = new TextArea();

    root.setCenter(textArea);

    Scene scene = new Scene(root, 400, 400);
    scene.getStylesheets().add("Style.css");

    primaryStage.setScene(scene);

    primaryStage.show();

    ScrollBar scrollBar = (ScrollBar) textArea.lookup(".scroll-bar:vertical");
    System.out.println(scrollBar);
    scrollBar.setDisable(true);
}