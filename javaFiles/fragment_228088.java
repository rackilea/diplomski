@FXML
public void minimizeClick() {
    minimizeButton.setOnAction(e ->
            ( (Stage) ( (Button) e.getSource() ).getScene().getWindow() ).setIconified(true)
    );
}