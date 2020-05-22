public class Main extends Application {
    private int lastClickedIndex = -1; 

    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root, 400, 400);


            Button[] digitButtons = new Button[10];
            for(int i = 0; i < 10; i++) {
                final int buttonInd = i;
                digitButtons[i] = new Button(Integer.toString(i));
                digitButtons[i].setOnAction(e -> {
                    System.out.println("Button pressed " + ((Button) e.getSource()).getText());
                    lastClickedIndex = buttonInd;
                });
            }

            root.setCenter(new HBox(digitButtons));

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}