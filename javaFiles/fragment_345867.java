public class ButtonedTabPane extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.UNAVAILABLE);

        // HBox of control buttons
        HBox hbox = new HBox();
        hbox.getChildren().addAll(createTabButton("min.png"), createTabButton("max.png"));

        // Anchor the controls
        AnchorPane anchor = new AnchorPane();
        anchor.getChildren().addAll(tabPane, hbox);
        AnchorPane.setTopAnchor(hbox, 3.0);
        AnchorPane.setRightAnchor(hbox, 5.0);
        AnchorPane.setTopAnchor(tabPane, 1.0);
        AnchorPane.setRightAnchor(tabPane, 1.0);
        AnchorPane.setLeftAnchor(tabPane, 1.0);
        AnchorPane.setBottomAnchor(tabPane, 1.0);

        // Create some tabs
        Tab tab = new Tab("Files");
        tab.setGraphic(createTabButton("files.png"));
        ((Button) tab.getGraphic()).setOnAction(e -> System.out.println("I'll show the list of files!"));
        tabPane.getTabs().add(tab);

        tab = new Tab("Network");
        tab.setGraphic(createTabButton("network.png"));
        ((Button) tab.getGraphic()).setOnAction(e -> System.out.println("I'll show the network!"));
        tabPane.getTabs().add(tab);

        root.setCenter(anchor);
        Scene scene = new Scene(root, 400, 400);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Button createTabButton(String iconName) {
        Button button = new Button();
        ImageView imageView = new ImageView(new Image(getClass().getResource(iconName).toExternalForm(),
                16, 16, false, true));
        button.setGraphic(imageView);
        button.getStyleClass().add("tab-button");
        return button;
    }

    public static void main(String[] args) {
        launch(args);
    }
}