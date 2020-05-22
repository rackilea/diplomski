AnchorPane anchorpane = new AnchorPane();
Button buttonSave = new Button("Save");
Button buttonCancel = new Button("Cancel");
anchorpane.setStyle("-fx-background-color: #A9A9A9;");
HBox hb = new HBox();
hb.getChildren().addAll(buttonSave, buttonCancel);
anchorpane.getChildren().addAll(hb);
anchorpane.setMinSize(300, 100);
AnchorPane.setRightAnchor(hb, 10.0);