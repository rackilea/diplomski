@Override
public void start(Stage primaryStage) throws Exception {
    final int count = 10;
    VBox root = new VBox();

    List<RadioButton> radios = new ArrayList<>(count);

    // create buttons
    for (int i = 0; i < count; i++) {
        RadioButton button = new RadioButton();
        button.setSelected(true);

        // prevent user interaction with button
        button.setDisable(true);

        // keep button visually the same as an enabled one
        button.setOpacity(1);

        radios.add(button);
    }

    root.getChildren().addAll(radios);

    Random random = new Random();
    Collections.shuffle(radios, random);

    // determine number of radios to deselect
    final int unselectCount = 1 + random.nextInt(count);

    final Iterator<RadioButton> iterator = radios.iterator();
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), event -> iterator.next().setSelected(false)));
    timeline.setCycleCount(unselectCount);
    timeline.play();

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}