@Override
public void start(Stage primaryStage) {

    Button btn = new Button();
    btn.setText("Show Sliding In Alert Dialog");
    btn.setOnAction(event -> {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Dialog");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("Are you ok with this?");

        ButtonBar buttonBar=(ButtonBar)alert.getDialogPane().lookup(".button-bar");
        buttonBar.setDisable(true);

        alert.initModality(Modality.APPLICATION_MODAL);
        alert.show();
        // now we can retrive alert bounds:
        double yIni=-alert.getHeight();
        double yEnd=alert.getY();
        // and move alert to the top of the screen
        alert.setY(yIni);

        final DoubleProperty yProperty = new SimpleDoubleProperty();
        yProperty.addListener((ob,n,n1)->alert.setY(n1.doubleValue()));

        Timeline timeIn = new Timeline();
        timeIn.getKeyFrames().add(
            new KeyFrame(Duration.seconds(1.5),
                 e->buttonBar.setDisable(false),
                 new KeyValue(yProperty, yEnd,Interpolator.EASE_BOTH)));
        timeIn.play();

        alert.resultProperty().addListener((ob,r,r1)->{
            if (r1 == ButtonType.OK){
                // alert is closed and hidden in its final position
            }
            else{
                primaryStage.close();
            }
        });

    });

    StackPane root = new StackPane();
    root.getChildren().add(btn);

    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Hello World!");
    primaryStage.setScene(scene);
    primaryStage.show();
}