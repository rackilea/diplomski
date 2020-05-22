@Override
public void start(Stage primaryStage) {
    Tab tab1 = new Tab("Tab 1", new Label("1"));
    Tab tab2 = new Tab("Tab 2", new Label("2"));

    TabPane tabPane = new TabPane();
    tabPane.setPrefSize(400, 400);

    CheckBox cb1 = new CheckBox("1");
    CheckBox cb2 = new CheckBox("2");
    cb1.selectedProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue) {
            tabPane.getTabs().add(0, tab1);
        } else {
            tabPane.getTabs().remove(tab1);
        }
    });
    cb2.selectedProperty().addListener((observable, oldValue, newValue) -> {
        if (newValue) {
            tabPane.getTabs().add(tab2);
        } else {
            tabPane.getTabs().remove(tab2);
        }
    });

    Scene scene = new Scene(new VBox(new HBox(cb1, cb2), tabPane));

    primaryStage.setScene(scene);
    primaryStage.show();
}