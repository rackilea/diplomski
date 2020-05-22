@FXML private Button button;
@FXML private MediaPlayer mediaPlayer;

@Override
public void initialize(URL url, ResourceBundle rb) {
    mediaPlayer.setOnEndOfMedia(()->button.setVisible(true));
}    

@FXML
public void playAndHide(ActionEvent event){
    button.setVisible(false);
    mediaPlayer.seek(Duration.ZERO);
    mediaPlayer.play();
}