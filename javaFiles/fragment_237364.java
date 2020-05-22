@FXML
private BorderPane BP;
@FXML
private Button ButtonID;

public static boolean main = true;

@Override
public void initialize(URL location, ResourceBundle resources) {

    try {
        final ParallelTransition mainButtonSplashAnimation = getMainButtonSplashAnimation();

        if (main) {
            final SequentialTransition splashedAnimation = getSplashedAnimation();
            SequentialTransition st = new SequentialTransition(splashedAnimation, mainButtonSplashAnimation);
            st.play();
        } else {
            mainButtonSplashAnimation.play();
        }
    } catch (IOException ex) {
        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
    }
}

@FXML
void ONButton(ActionEvent event) {

}

private SequentialTransition getSplashedAnimation() throws IOException {
    main = false;
    BorderPane bps = FXMLLoader.load(getClass().getResource("SPLASH.fxml"));

    BP.getChildren().setAll(bps);

    FadeTransition fdin = new FadeTransition((javafx.util.Duration.seconds(3)), bps);
    fdin.setFromValue(0);
    fdin.setToValue(1);

    FadeTransition fadeTransition = new FadeTransition(javafx.util.Duration.seconds(3), bps);
    fadeTransition.setToValue(0);

    SequentialTransition st = new SequentialTransition(fdin, fadeTransition);

    st.setOnFinished(e -> {
        try {
            BorderPane bpss = FXMLLoader.load(getClass().getResource("sample.fxml"));
            BP.getChildren().setAll(bpss);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    });

    return st;

}

public ParallelTransition getMainButtonSplashAnimation() {

    PathTransition pathTransition = new PathTransition();
    pathTransition.setDuration(javafx.util.Duration.seconds(2));
    pathTransition.setNode(ButtonID);
    pathTransition.setPath(new Line(0, 0, 200, 0));
    FadeTransition fadeTransition = new FadeTransition(javafx.util.Duration.seconds(1), ButtonID);
    fadeTransition.setFromValue(0);
    fadeTransition.setToValue(1);

    ParallelTransition pt = new ParallelTransition(pathTransition, fadeTransition);
    return pt;

}