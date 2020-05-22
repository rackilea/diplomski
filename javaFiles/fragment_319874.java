public class setLay extends Application{

    private int currentQuestionIndex = 0 ;

    String[]text = new String[4];

    Label label = new Label();

    Button next = new Button("Next");
    @Override

    public void start(Stage primaryStage) throws Exception {

        text[0]= "What's the capital of Monaco?";
        text[1] = "What's the capital of San Marino?";
        text[2] = "What's the capital of Lithuania?";
        text[3] = "What's the capital of Denmark?";

        label.setText(text[0]);
        label.setTranslateX(200);

        next.setOnAction(e -> makeLabel());

        Stage stage = new Stage();
        Pane pane = new Pane();
        Scene scene = new Scene(pane, 800, 500);
        stage.setScene(scene);
        stage.show();

        pane.getChildren().addAll(label, next);

    }

    public void makeLabel() {
        currentQuestionIndex = (currentQuestionIndex + 1) % text.length ;
        label.setText(text[currentQuestionIndex]);
    }
}