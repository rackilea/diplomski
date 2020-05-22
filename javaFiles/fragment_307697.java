for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 20; j++) {
            Button button = new Button();
            button.setText("Помещение №" + count++);
            button.getStyleClass().add("button-all");
            button.prefWidthProperty().bind(Bindings.divide(gridPane.widthProperty(), 10));
            button.prefHeightProperty().bind(Bindings.divide(gridPane.heightProperty(), 20));
            //gridPane.getRowConstraints().add(new RowConstraints(HEIGHT));
            //gridPane.getColumnConstraints().add(new ColumnConstraints(WIDTH));
            gridPane.add(button, i, j);
        }
    }