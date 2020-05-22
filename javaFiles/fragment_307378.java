public class MyApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        SceneController sceneController = new SceneController();
        BorderPane root = new BorderPane();
        Button showView1 = new Button("View 1");
        Button showView2 = new Button("View 2");
        ButtonBar buttonBar = new ButtonBar();
        buttonBar.getButtons().addAll(showView1, showView2);
        root.setTop(buttonBar);

        showView1.setOnAction(e -> root.setCenter(sceneController.getView1()));  
        showView2.setOnAction(e -> root.setCenter(sceneController.getView2()));

        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}