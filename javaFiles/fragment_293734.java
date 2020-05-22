// Create dialog
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/exportDialog.fxml" ));
    AnchorPane exportDialog = (AnchorPane) loader.load();
    exportController = (ExportDialogController)loader.getController();
    Stage dialogStage = new Stage();

    dialogStage.setOnCloseRequest(event -> exportController.close());

    dialogStage.setTitle("Export...");
    dialogStage.initModality(Modality.WINDOW_MODAL);
    dialogStage.initOwner(this.stage);
    Scene scene = new Scene(exportDialog);
    dialogStage.setScene(scene);
    dialogStage.show();