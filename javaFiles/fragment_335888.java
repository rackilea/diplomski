@Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        StackPane root = new StackPane();
        TabPane pane = new TabPane();
        pane.setId(("MyTabPane"));
        Tab tab1 = new Tab("ONE");
        Tab tab2 = new Tab("TWO");
        Tab tab3 = new Tab("THREE");
        pane.getTabs().addAll(tab1,tab2,tab3);
        Scene scene = new Scene(root, 300, 250);
        root.getChildren().add(pane);
        scene.getStylesheets().add(
                this.getClass().getClassLoader().getResource("tabpaneex/TabExample.css").toString());
        primaryStage.setScene(scene);
        primaryStage.show();
    }