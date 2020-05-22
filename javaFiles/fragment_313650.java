public DialogController createDialog(Settings settings, int size){
      final FXMLLoader loader = new FXMLLoader(FXMLLoader.class.getResource("/fxml/afxm.fxm"));
      try {
            final Stage stage = new Stage();
            stage.setScene(new Scene(loader.load()));
            final DialogController controller = loader.getController();
            controller.setSettings(settings,size);
            stage.show();
            return controller;
       } catch (IOException ex) {
            throw new InternalApplicationError("Resource missing", ex);
       }
  }