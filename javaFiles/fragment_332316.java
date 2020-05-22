@Override
public void start(Stage primaryStage) {
    Button btn = new Button("Dialog");
    List<String> list = Arrays.asList("A", "B", "C", "D");
    btn.setOnAction((ActionEvent event) -> {
        displayDialog(list.iterator());
    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}

public static void displayDialog(Iterator<String> iterator) {
    if (iterator.hasNext()) {
        Button yes = new Button("Yes");
        Button no = new Button("No");
        Label text = new Label(iterator.next());
        Stage stage = new Stage();
        stage.setScene(new Scene(new VBox(text, yes, no)));
        EventHandler<ActionEvent> handler = evt -> {
            Labeled source = (Labeled) evt.getSource();
            System.out.println("You chose \"" + source.getText() + "\" for \"" + text.getText() + "\"");

            // procede to next state
            if (iterator.hasNext()) {
                // display next item
                text.setText(iterator.next());
            } else {
                // close "dialog" when no more elements available
                stage.close();
            }
        };
        yes.setOnAction(handler);
        no.setOnAction(handler);
        stage.show();
    }
}