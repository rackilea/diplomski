public class MainNoFXML extends Application {

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {
        ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(new String[]{"Monday", "Tuesday", "Wednesday", "Thrusday", "Friday"}));
        comboBox.setOnAction(event -> {
            System.out.println("Selected:"+comboBox.getValue().toString());
            System.out.println("All:"+comboBox.getItems().toString());
        });

        Scene scene = new Scene(comboBox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}