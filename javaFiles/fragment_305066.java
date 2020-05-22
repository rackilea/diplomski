public class ListItemControl extends HBox {
       // associate the control to the fxml
  public ListItemControl() {
        FXMLLoader fxmlLoader = new 
          FXMLLoader(getClass().getResource("/com/company/fxml/listItem.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    }