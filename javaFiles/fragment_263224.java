public void start(Stage primaryStage) throws Exception {
        GridPane chessTable = new GridPane();
        chessTable.getStylesheets().add(getClass().getResource("/styles.css").toString());
        for (int h = 0; h < 8; h++) {
            for (int w = 0; w < 8; w++) {
                Box chessBox = new Box(112, 94, 0);
                chessBox.getStyleClass().add("chess-box");
                GridPane.setConstraints(chessBox, w, h);
                chessTable.getChildren().add(chessBox);

            }
        }