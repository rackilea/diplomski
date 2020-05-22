TableView<?> table1 = createTable();
TableView<?> table2 = createTable();
table1.minWidthProperty().bind(primaryStage.widthProperty().multiply(0.2));
table2.minWidthProperty().bind(primaryStage.widthProperty().multiply(0.7));

SplitPane split = new SplitPane(table1,table2);