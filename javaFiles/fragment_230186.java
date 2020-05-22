GridPane root = new GridPane();
ColumnConstraints col1 = new ColumnConstraints();
col1.setPercentWidth(50);
ColumnConstraints col2 = new ColumnConstraints();
col2.setPercentWidth(50);
root.getColumnConstraints().addAll(col1,col2);
root.addRow(0, leftCol,rightCol);