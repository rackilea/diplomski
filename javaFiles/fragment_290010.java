@Override
public void start(Stage primaryStage) {
    Image image = new Image("http://cdn.sstatic.net/Sites/stackoverflow/company/img/logos/so/so-icon.png?v=c78bd457575a");

    FlowPane imagePane = new FlowPane();
    imagePane.setHgap(20);
    imagePane.setVgap(130 - 50);
    imagePane.setRowValignment(VPos.CENTER);
    imagePane.setColumnHalignment(HPos.LEFT);

    ScrollPane scroll = new ScrollPane(imagePane);
    scroll.setFitToWidth(true);
    scroll.setPrefSize(380, 300);

    BorderPane root = new BorderPane(scroll);

    Button btn = new Button("Add Image");
    btn.setOnAction((ActionEvent event) -> {
        ImageView newImage = new ImageView(image);
        newImage.setFitHeight(50);
        newImage.setFitWidth(100);
        imagePane.getChildren().add(newImage);
    });

    root.setLeft(new VBox(btn));

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}