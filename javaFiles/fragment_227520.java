@Override
public void start(Stage stage) throws Exception {
    JFXTextArea textArea = new JFXTextArea();

    ToggleButton toggle = new ToggleButton("monospaced");
    toggle.setSelected(true);

    textArea.fontProperty().bind(
            Bindings.when(toggle.selectedProperty()).then(Font.font("monospaced")).otherwise(Font.getDefault()));

    textArea.setText(
            "+-----------+----------------------+\n"
          + "|   R1      |   R2                 |\n"
          + "+-----------+----------------------+\n"
          + "|  **DONE** |     ***DONE***       |\n"
          + "+-----------+----------------------+");

    stage.setScene(new Scene(new VBox(toggle, textArea)));
    stage.show();
}