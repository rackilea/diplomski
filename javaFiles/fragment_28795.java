Text name = new Text("Name: ");
name.setFill(Color.BLUE);
name.setFont(Font.font("Helvetica", FontWeight.BOLD, 12));
Text info = new Text(innerNode.name);
HBox hbox = new HBox(1);
hbox.getChildren().addAll(name, info);