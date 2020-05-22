public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            HBox root = new HBox();

            TextField sizeMatrix = new TextField();
            sizeMatrix.setPromptText("Size");

            TextField amountLivingCells = new TextField();
            amountLivingCells.setPromptText("living Cells");

            Button applyButton = new Button("Apply settings");
            applyButton.setOnAction(e -> {
                //Remove Old matrix
                GridPane oldMatrix = null;
                for (Node child : root.getChildren()) {
                    if(child instanceof GridPane) {
                        oldMatrix = (GridPane) child;
                        break;
                    }
                }
                root.getChildren().remove(oldMatrix);

                int size = Integer.parseInt(sizeMatrix.getText());
                int amountCells = Integer.parseInt(amountLivingCells.getText());

                //Build and Add new Matrix
                GridPane newMatrix = buildNewMatrix(size, amountCells);
                root.getChildren().add(newMatrix);

                //No longer needed
                //LogicMinimal.newMatrix(matrix, size1);
                //LogicMinimal.fillMatrixWithDeadCells(matrix, size1);
                //LogicMinimal.randomlySetLivingCells(matrix, amountCells, size1);
            });

            VBox settings = new VBox();
            settings.getChildren().addAll(sizeMatrix, amountLivingCells, applyButton);
            settings.setSpacing(20);

            GridPane matrix = buildNewMatrix(12, 30);

            root.getChildren().addAll(settings, matrix);


            Scene scene = new Scene(root,800,800);
            //scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

            primaryStage.setScene(scene);
            primaryStage.show();

            applyButton.requestFocus();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    private GridPane buildNewMatrix(int initialSize, int initialAmountBlackCells){
        GridPane newMatrix = new GridPane();
        newMatrix.setMinHeight(400);
        newMatrix.setMinWidth(400);
        newMatrix.setMaxHeight(400);
        newMatrix.setMaxWidth(400);

        NumberBinding size = Bindings.min(newMatrix.widthProperty(),
                newMatrix.heightProperty().subtract(50))
                .divide(20);

        //binding for size rounded down
        NumberBinding roundedSize = Bindings.createIntegerBinding(size::intValue, size);

        //initialize newMatrix
        setConstraints(newMatrix, initialSize);

        //fill out newMatrix with white Rectangles
        setBlankRectangles(newMatrix, roundedSize, initialSize);

        setRandomlyBlackRectangles(newMatrix, initialAmountBlackCells, initialSize);

        return newMatrix;
    }

    private void setRandomlyBlackRectangles(GridPane matrix, int amount, int sizeMatrix) {
        for(int i = 0; i < amount; i++)
        {
            int randomCol = ThreadLocalRandom.current().nextInt(0, sizeMatrix + 1);//Change 1 to 0 to allow to be placed in col 0
            int randomRow = ThreadLocalRandom.current().nextInt(0, sizeMatrix + 1);//Change 1 to 0 to allow to be placed in row 0

            for (Node node : matrix.getChildren())
            {
                if (node instanceof Rectangle &&
                        GridPane.getColumnIndex(node) == randomCol &&
                        GridPane.getRowIndex(node) == randomRow)
                {
                    Rectangle cell = (Rectangle)node;
                    cell.setFill(Color.BLACK);
                }
            }
        }
    }

    private void setBlankRectangles(GridPane matrix, NumberBinding roundedSize, int size) {
        for(int column = 0; column < size; column++)
        {
            for(int row = 0; row < size; row++)
            {
                Rectangle dead_cell = new Rectangle();
                dead_cell.setFill(Color.WHITE);
                dead_cell.widthProperty().bind(roundedSize);
                dead_cell.heightProperty().bind(roundedSize);

                GridPane.setColumnIndex(dead_cell, column);
                GridPane.setRowIndex(dead_cell, row);
                matrix.add(dead_cell, column, row);
            }
        }
    }

    private void setConstraints(GridPane matrix, int size) {

        matrix.getRowConstraints().removeAll(matrix.getRowConstraints());
        matrix.getColumnConstraints().removeAll(matrix.getColumnConstraints());

        double cellWidth;
        double cellHeight;

        for(int i = 0; i < size; i++)
        {
            ColumnConstraints colConst = new ColumnConstraints();
            cellWidth = 100.0 / size;
            colConst.setPercentWidth(cellWidth);
            matrix.getColumnConstraints().add(colConst);

            RowConstraints rowConst = new RowConstraints();
            cellHeight = 100.0 / size;
            rowConst.setPercentHeight(cellHeight);
            matrix.getRowConstraints().add(rowConst);
        }
    }
}