Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Duplicate");
alert.setHeaderText("This folder already exists");
alert.setContentText("Do you want to continue (this program will overwrite any files with duplicate names)");

ButtonType show = new ButtonType("Show in Explorer", ButtonBar.ButtonData.LEFT);
alert.getButtonTypes().add(show);

ButtonBar.setButtonUniformSize(alert.getDialogPane().lookupButton(show), false);
alert.getDialogPane().lookupButton(show).addEventFilter(ActionEvent.ACTION, event -> {
    try {
        Desktop.getDesktop().open(new File(new File(file.getPath())));
    }
    catch (IOException e) {
        e.printStackTrace();
    }

    event.consume();
});

Optional<ButtonType> option = alert.showAndWait();
return ButtonType.OK.equals(option.get());