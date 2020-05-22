@Override
public void start(Stage stage) throws Exception {
    Duration d = Duration.seconds(1);

    Rectangle rect = new Rectangle(50, 50);
    TranslateTransition t1 = new TranslateTransition(d, rect);
    t1.setToX(350);
    TranslateTransition t2 = new TranslateTransition(d, rect);
    t2.setToY(350);
    TranslateTransition t3 = new TranslateTransition(d, rect);
    t3.setToX(0);
    TranslateTransition t4 = new TranslateTransition(d, rect);
    t4.setToY(0);

    SequentialTransition transition = new SequentialTransition(t1, t2, t3, t4);
    transition.setCycleCount(Animation.INDEFINITE);
    transition.play();

    Pane pane = new Pane(rect);
    pane.setPrefSize(400, 400);

    Slider slider = new Slider(0.1, 4, 1);
    transition.rateProperty().bind(slider.valueProperty());

    stage.setScene(new Scene(new VBox(slider, pane)));
    stage.show();
}