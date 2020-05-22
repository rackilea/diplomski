DatePicker datePicker = new DatePicker();
datePicker.setMinHeight(12.);
datePicker.setPrefHeight(16.);
HBox hBox = new HBox();
hBox.getChildren().add(new Label("DatePicker with 16px height"));
hBox.getChildren().add(datePicker);