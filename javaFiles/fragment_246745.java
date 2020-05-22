@Override
    public void start(Stage stage) throws Exception {
        Label promptLabel = new Label("Start");

        MenuButton menuButton = new MenuButton();
        menuButton.setGraphic(promptLabel);

        Label choice1Label = new Label("Choice 1");
        MenuItem menuItem1 = new MenuItem();
        menuItem1.setGraphic(choice1Label);

        menuButton.getItems().add(menuItem1);

        menuItem1.setOnAction(e -> {
            String text = ((Label) menuItem1.getGraphic()).getText();
            ((Label) menuButton.getGraphic()).setText((text));
        });

        Pane pane = new Pane();
        pane.getChildren().addAll(menuButton);

        Scene scene = new Scene(pane);
        scene.getStylesheets().add(this.getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }