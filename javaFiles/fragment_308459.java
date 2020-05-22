FXMLLoader fx = new FXMLLoader(Paths.get("../file.fxml").toUri().toURL());
Scene scene = new Scene(fx.load());
primaryStage.setScene(scene);
primaryStage.show();
primaryStage.centerOnScreen();

FileController control = (FileController ) fx.getController();
control.setOnValidate(() -> System.out.println("here 1"));