// Label 1
Label lbl1 = new Label("Label1");
lbl1.setMaxWidth(Double.MAX_VALUE);
lbl1.setStyle("-fx-border-style: solid; -fx-background-color: #80aaff; -fx-border-width: 0.25");
// Label 2
Label lbl2 = new Label("Label2");
lbl2.setStyle("-fx-border-style: solid; -fx-background-color:#ff80bf; -fx-border-width: 0.25");
lbl2.setMaxWidth(Double.MAX_VALUE);
// Label 3
Label lbl3 = new Label("Label3");
lbl3.setMaxWidth(Double.MAX_VALUE);
lbl3.setStyle("-fx-border-style: solid; -fx-background-color:#66ff99; -fx-border-width: 0.25");
// Label 4
Label lbl4 = new Label("Label4");
lbl4.setMaxWidth(Double.MAX_VALUE);
lbl4.setStyle("-fx-border-style: solid; -fx-background-color: #ffff66; -fx-border-width: 0.25");

GridPane gridPane = new GridPane();

ColumnConstraints constraints = new ColumnConstraints(100);
gridPane.getColumnConstraints().addAll(constraints, constraints, constraints);

gridPane.setStyle("-fx-border-style: solid");

// column 0, row 0, column span 1, row span 1
gridPane.add(lbl1, 0, 0);
// column 1, row 0, column span 2, row span 1
gridPane.add(lbl2, 1, 0, 2, 1);
// column 0, row 1, column span 1, row span 1
gridPane.add(lbl3, 0, 1, 2, 1);
// column 2, row 1, column span 2, row span 1
gridPane.add(lbl4, 2, 1);