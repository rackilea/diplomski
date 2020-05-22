@Override
    public void start(Stage primaryStage) throws Exception{
        TextField textfield = new TextField();
        ListView listView = new ListView();
        listView.getItems().add("One");
        listView.getItems().add("Two");
        listView.getItems().add("Three");
        Button button = new Button("Button");

        VBox root = new VBox(5, textfield, listView, button);
        root.addEventFilter(KeyEvent.KEY_PRESSED, event->{
            if (event.getCode() == KeyCode.SPACE) {
                System.out.println("GOOD");
            }
        });
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }