Alert alert = new Alert(Alert.AlertType.WARNING, "I Warn You!", ButtonType.OK, ButtonType.CANCEL);
DialogPane root = alert.getDialogPane();

Stage dialogStage = new Stage(StageStyle.UTILITY);

for (ButtonType buttonType : root.getButtonTypes()) {
    ButtonBase button = (ButtonBase) root.lookupButton(buttonType);
    button.setOnAction(evt -> {
        root.setUserData(buttonType);
        dialogStage.close();
    });
}

// replace old scene root with placeholder to allow using root in other Scene
root.getScene().setRoot(new Group());

root.setPadding(new Insets(10, 0, 10, 0));
Scene scene = new Scene(root);

dialogStage.setScene(scene);
dialogStage.initModality(Modality.APPLICATION_MODAL);
dialogStage.setAlwaysOnTop(true);
dialogStage.setResizable(false);
dialogStage.showAndWait();
Optional<ButtonType> result = Optional.ofNullable((ButtonType) root.getUserData());
System.out.println("result: "+result.orElse(null));