public class Main extends Application {


    @Override
    public void start(Stage primaryStage) {

        Button btn1 = new Button("Botao 1");
        Button btn2 = new Button("Botao 2");
        Button btn3 = new Button("Botao 3");
        Button btn4 = new Button("Botao 4");
        Button btn5 = new Button("Botao 5");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(btn1, btn2, btn3, btn4, btn5);

        BorderPane root = new BorderPane(); 
        root.setBottom(hbox);

        primaryStage.setTitle("Border Layout");
        primaryStage.setScene(new Scene(root, 450, 250));
        primaryStage.show();
    }


    public static void main(String[] args) {
         launch(args);
    }

}