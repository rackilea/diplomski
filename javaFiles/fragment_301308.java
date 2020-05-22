@Override
public void start(Stage primaryStage) {
    GridPane gp = new GridPane();
    ColumnConstraints constraints = new ColumnConstraints();
    constraints.setHalignment(HPos.CENTER);
    constraints.setPercentWidth(50);

    gp.getColumnConstraints().addAll(constraints, constraints);
    Random random = new Random();

    Node[][] elements = new Node[2][10];

    for (int x = 0; x < elements.length; x++) {
        final Node[] column = elements[x];
        InvalidationListener sizeListener = o -> {
            // determine max width
            double maxSize = 0;

            for (Node n : column) {
                double width = n.getLayoutBounds().getWidth();
                if (width > maxSize) {
                    maxSize = width;
                }
            }

            // adjust translate
            for (Node n : column) {
                n.setTranslateX((n.getLayoutBounds().getWidth() - maxSize) / 2);
            }
        };

        // fill column with strings of random lenght
        for (int y = 0; y < 10; y++) {
            int charCount = random.nextInt(30);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charCount; i++) {
                sb.append('a');
            }
            Label text = new Label(sb.toString());
            text.layoutBoundsProperty().addListener(sizeListener);
            column[y] = text;
        }
        gp.addColumn(x, column);
        sizeListener.invalidated(null);
    }

    Scene scene = new Scene(gp);

    primaryStage.setScene(scene);
    primaryStage.show();
}