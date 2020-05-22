final Model model = new Model();

FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("path/to/fxml/file.fxml"));
loader.setController(new MyController(model));
Parent root = loader.<Parent>load();