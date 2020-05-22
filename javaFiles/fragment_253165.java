GridPane grid = new GridPane();
grid.setPadding(new Insets(10, 10, 10, 10));
grid.setMinSize(300, 300);
grid.setVgap(5);
grid.setHgap(5);

Text username = new Text("Username:");
grid.add(username, 0, 0);

TextField text = new TextField();
text.setPrefColumnCount(10);
grid.add(text, 1, 0);

Text password = new Text("Password:");
grid.add(password, 0, 1);

TextField text2 = new TextField();
text2.setPrefColumnCount(10);
grid.add(text2, 1, 1);
grid.setStyle("-fx-background-color: #D8BFD8");