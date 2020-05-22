Scene scene = new Scene(new HBox());
Stage stage = new Stage;
stage.setScene(scene);
for (URL url : stylesheets) 
{
    stage.getScene().getStylesheets().add(url.toExternalForm());
}