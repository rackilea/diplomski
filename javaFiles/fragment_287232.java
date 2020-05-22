public class JavaFXApplication1 extends Application {

    class MyObj {

        String toDisplay;
        double rand;

        public MyObj(String toDisplay) {
            this.toDisplay = toDisplay;
            rand = Math.random();
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ListView listView = new ListView<>(FXCollections.observableArrayList(new MyObj("Item1"), new MyObj("Item2")));
        listView.setEditable(true);

        listView.setCellFactory((list) -> {
            return new TextFieldListCell(new StringConverter<MyObj>() {
                @Override
                public String toString(MyObj object) {
                    return object.toDisplay;
                }

                @Override
                public MyObj fromString(String string) {
                    return new MyObj(string);
                }
            });
        });

        HBox hbox = new HBox(listView);
        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}