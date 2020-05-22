ColumnConstraints leftCol = new ColumnConstraints();
leftCol.setHgrow(Priority.ALWAYS);
ColumnConstraints middleCol = new ColumnConstraints(40);
ColumnConstraints rightCol = new ColumnConstraints();
rightCol.setHgrow(Priority.ALWAYS);

GridPane gridPane = new GridPane();
gridPane.getColumnConstraints().addAll(leftCol, middleCol, rightCol);