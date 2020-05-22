FXMLLoader loader = new FXMLLoader(getClass().getResource("second.fxml"));
Stage subStage = new Stage();
subStage.initModality(Modality.APPLICATION_MODAL);
subStage.setTitle("Second Window");
Scene scene = new Scene(loader.load());
subStage.setScene(scene);
subStage.showAndWait();

Optional<Person> result = loader.<Supplier<Optional<Person>>>getController().get();

if (result.isPresent()) {
    // do something with the result
}