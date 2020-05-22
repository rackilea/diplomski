private static final int COLUMN_COUNT = 3;
private int nextColumnIndex = COLUMN_COUNT;
private int currentRow = -1;

@Override
public void start(Stage primaryStage) {
    Image image = new Image("http://cdn.sstatic.net/Sites/stackoverflow/company/img/logos/so/so-icon.png?v=c78bd457575a");

    GridPane imagePane = new GridPane();

    ColumnConstraints colConstraint = new ColumnConstraints(120);
    colConstraint.setHalignment(HPos.LEFT);

    RowConstraints rowConstraints = new RowConstraints(130);
    rowConstraints.setValignment(VPos.CENTER);

    // add constraints for columns
    imagePane.getColumnConstraints().addAll(colConstraint, colConstraint, colConstraint);

    ScrollPane scroll = new ScrollPane(imagePane);
    scroll.setFitToWidth(true);
    scroll.setPrefSize(380, 300);

    BorderPane root = new BorderPane(scroll);

    Button btn = new Button("Add Image");
    btn.setOnAction((ActionEvent event) -> {
        ImageView newImage = new ImageView(image);
        newImage.setFitHeight(50);
        newImage.setFitWidth(100);
        if (nextColumnIndex >= COLUMN_COUNT) {
            nextColumnIndex = 0;
            currentRow++;
            imagePane.getRowConstraints().add(rowConstraints);
        }
        imagePane.addRow(currentRow, newImage);
        nextColumnIndex++;
    });

    root.setLeft(new VBox(btn));

    Scene scene = new Scene(root);

    primaryStage.setScene(scene);
    primaryStage.show();
}