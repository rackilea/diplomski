public class Controller implements Initializable 
{

  @FXML
  private Pane pane ;

  // ...    

  public void openFile()
  { 
    fileChooser = new FileChooser();
    file = fileChooser.showOpenDialog(pane.getScene().getWindow());

    if (file != null)
    {
      // display the image in the pane
      pane.getChildren().add(new ImageView(file.toURI().toURL().toExternalForm()));
    }
  }
}