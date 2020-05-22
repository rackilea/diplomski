public void start(Stage primaryStage)throws Exception{
    ////////////////////Basic FX stuff
    Canvas theCanvas = new Canvas(900,900);
    StackPane theLayout = new StackPane();
    theLayout.getChildren().add(theCanvas);
    Scene theScene = new Scene(theLayout,900,900);
    primaryStage.setScene(theScene);
    primaryStage.show();
    ///////////////////////
    /////Drawing an X
    ///////////////////////
    GraphicsContext gc = theCanvas.getGraphicsContext2D();

    Timeline timeline = new Timeline(
        new KeyFrame(Duration.seconds(1), e -> gc.strokeLine(0,0,200,200)),
        new KeyFrame(Duration.seconds(2), e -> gc.strokeLine(200,0,0,200))
    );
    timeline.play();
    /////////////////////////////
}