@Override
public void start(Stage primaryStage) {

    Label label = new Label("Bla bla bla bla");

    Button btn = new Button("flash");
    VBox box = new VBox(10, label, btn);
    box.setPadding(new Insets(10));

    btn.setOnAction((ActionEvent event) -> {

        //**************************
        //this animation changes the background color
        //of the VBox from red with opacity=1 
        //to red with opacity=0
        //**************************
        final Animation animation = new Transition() {

            {
                setCycleDuration(Duration.millis(1000));
                setInterpolator(Interpolator.EASE_OUT);
            }

            @Override
            protected void interpolate(double frac) {
                Color vColor = new Color(1, 0, 0, 1 - frac);
                box.setBackground(new Background(new BackgroundFill(vColor, CornerRadii.EMPTY, Insets.EMPTY)));
            }
        };
        animation.play();

    });

    Scene scene = new Scene(box, 100, 100);

    primaryStage.setScene(scene);
    primaryStage.show();

}