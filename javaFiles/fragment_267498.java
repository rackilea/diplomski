public class Calculator extends Application {

 private TextField textField = new TextField(); 

 @Override
 public void start(Stage primaryStage) {

    List<String> buttons = Arrays.asList("7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "=", "/", "EE");

    FlowPane pane = new FlowPane();
    pane.setAlignment(Pos.CENTER);
    pane.setPadding(new Insets(30, 20, 30, 20));
    pane.setHgap(5);
    pane.setVgap(5);
    pane.setMinWidth(400);
    pane.setPrefWidth(400);
    pane.setMaxWidth(400);

    textField.setEditable(false);
    textField.setAlignment(Pos.CENTER);
    textField.setMinSize(336, 40);
    // Rezultat.textProperty().bind(Bindings.format("%.0f", value));
    pane.getChildren().add(textField);

    for (String button : buttons) {
        Button b = new Button(button);
        b.setMinSize(80, 80);
        pane.getChildren().add(b);
        b.setOnAction((e) -> doSomething(b.getText()));
    }

    Scene scene = new Scene(pane);
    primaryStage.setTitle("Calculator");
    primaryStage.setScene(scene);
    primaryStage.show();

}

private void doSomething(String text) {

    if (text.equalsIgnoreCase("=")) {
        // Calc
    }

    else if (text.equalsIgnoreCase("EE")) {
        // EE
    } else if (text.equalsIgnoreCase("+") || text.equalsIgnoreCase("-") || text.equalsIgnoreCase("*") || text.equalsIgnoreCase("/")) {
        // + - * /
    }
    // ....
    else {
        // numeric
        textField.appendText(text);
    }
}

public static void main(String[] args) {
    Application.launch(args);

}

}