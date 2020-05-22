@Override
public void start(Stage primaryStage) throws Exception {
    ListView<String> listView = new ListView<>();
    for (int i = 0; i < 30; i++) {
        listView.getItems().add("item " + i);
    }

    final long minDelay = 3 * 1000; // 3 sec min

    listView.setCellFactory(lv -> new ListCell<String>() {

        private long pressTime;

        {
            setOnMousePressed(evt -> {
                if (!isEmpty()
                        && evt.getButton() == MouseButton.PRIMARY) {
                    pressTime = System.currentTimeMillis(); // save time of press start
                }
            });
            setOnMouseReleased(evt -> {
                if (!isEmpty()
                        && evt.getButton() == MouseButton.PRIMARY
                        && pressTime + minDelay <= System.currentTimeMillis()) {
                    System.out.println("long press on " + getItem()); // do something, if enough time has ellapsed since press
                }
            });
        }

        @Override
        protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
            setText(item);
        }

    });

    primaryStage.setScene(new Scene(listView, 500, 500));
    primaryStage.show();
}