@Override
public void start(Stage primaryStage) {
    String[][] data = {
        {"Hello", "World"},
        {"Hello2", "World2"},
        {"Hello3", "World3"},
        {"Hello4", "World4"},
        {"Hello5", "World5"},
        {"Hello6", "World6"}
    };

    Insets margin = new Insets(4);

    int nextRow = 1;
    GridPane gridPane = new GridPane();

    Text heading1 = new Text("BaseFormula");
    Text heading2 = new Text("BasePT");

    GridPane.setMargin(heading1, margin);
    GridPane.setMargin(heading2, margin);

    gridPane.addRow(0, heading1, heading2);
    for (String[] d : data) {
        TextField tf = new TextField(d[0]);
        TextField tf2 = new TextField(d[1]);

        GridPane.setMargin(tf, margin);
        GridPane.setMargin(tf2, margin);

        gridPane.addRow(nextRow++, tf, tf2);
    }

    // add lines

    // subtract stroke width
    DoubleBinding height = gridPane.heightProperty().subtract(1);
    // margin = 1/2 stroke width
    Insets vMargin = new Insets(0.5, 0, 0.5, 0);

    // add vertical lines
    for (int i = 0; i < 3; i++) {
        Line vLine = new Line();
        GridPane.setMargin(vLine, vMargin);
        System.out.println(vLine.getStrokeWidth());
        vLine.endYProperty().bind(height);
        gridPane.add(vLine, i, 0, 1, nextRow);
    }

    // procede accordingly with horizontal lines
    DoubleBinding width = gridPane.widthProperty().subtract(1);
    Insets hMargin = new Insets(0, 0.5, 0, 0.5);

    for (int i = 0; i <= nextRow; i++) {
        Line hLine = new Line();
        GridPane.setMargin(hLine, hMargin);
        hLine.setStartX(1);
        hLine.endXProperty().bind(width);

        // Insert at the top of the cell
        GridPane.setValignment(hLine, VPos.TOP);
        gridPane.add(hLine, 0, i, 2, 1);
    }

    Scene scene = new Scene(new StackPane(new Group(gridPane)), 500, 500);

    primaryStage.setScene(scene);
    primaryStage.show();
}