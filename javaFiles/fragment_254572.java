FXMLLoader loader = new FXMLLoader(getClass().getResource("/path/to/fxml"));
Parent root = loader.load();
Scene scene = new Scene(root);
someStage.setScene(scene);

ServerController controller = loader.getController();
someStage.setOnCloseRequest(e -> controller.shutdown());