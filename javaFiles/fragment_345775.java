public class MyApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        ImageView lena = new ImageView(new Image("main/Lenna.png")); //URL to image

        Text text1 = new Text("Hello World!");
        text1.setRotate(30);
        text1.setTranslateX(100);
        text1.setTranslateY(-100);
        text1.setFont(Font.font("Veranda", FontWeight.BOLD, 36));
        text1.setFill(Color.BLUE);

        Text text2 = new Text("Hello Lenna!");
        PerspectiveTransform perspectiveTrasform = new PerspectiveTransform();
        perspectiveTrasform.setUlx(10);
        perspectiveTrasform.setUly(10);
        perspectiveTrasform.setUrx(300);
        perspectiveTrasform.setUry(40);
        perspectiveTrasform.setLrx(300);
        perspectiveTrasform.setLry(60);
        perspectiveTrasform.setLlx(10);
        perspectiveTrasform.setLly(90);
        text2.setEffect(perspectiveTrasform);
        text2.setFont(Font.font("Veranda", FontWeight.BOLD, 36));

        StackPane pane = new StackPane(lena, text1, text2);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception {

        launch(args);
    }
}