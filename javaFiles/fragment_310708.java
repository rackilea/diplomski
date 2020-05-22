@Override
public void start(Stage primaryStage) {
    BorderPane borderPane = new BorderPane();
    Image image1 = new Image("https://cdn.sstatic.net/Sites/stackoverflow/company/img/logos/se/se-logo.png?v=dd7153fcc7fa");
    Image image2 = new Image("https://cdn.sstatic.net/Sites/stackoverflow/company/img/logos/so/so-logo.png?v=9c558ec15d8a");

    BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);

    Background background2 = new Background(new BackgroundImage(image2,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bSize));

    borderPane.setBackground(new Background(new BackgroundImage(image1,
            BackgroundRepeat.NO_REPEAT,
            BackgroundRepeat.NO_REPEAT,
            BackgroundPosition.CENTER,
            bSize)));

    Button btn = new Button("Change Background");
    btn.setOnAction((ActionEvent event) -> {
        borderPane.setBackground(background2);
    });

    borderPane.setCenter(btn);

    Scene scene = new Scene(borderPane, 600, 400);

    primaryStage.setScene(scene);
    primaryStage.show();
}