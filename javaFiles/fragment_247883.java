public void setAreaText(String text) {
    area.setText(text);
}

@FXML
public void lyricsClicked() {
    Parent root;
    try {

        //root = FXMLLoader.load(getClass().getResource("/lyrics.fxml"));
        URL location = getClass().getResource("/lyrics.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(location);
        fxmlLoader.setBuilderFactory(new JavaFXBuilderFactory());
        root = fxmlLoader.load(location.openStream());
        YoutubeController contr = fxmlLoader.getController();
        contr.setAreaText(lyrics);

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Lyrics");
        stage.show();

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}