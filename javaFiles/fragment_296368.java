public void Display(){

       Dialog<ButtonType>DisplaySong = new Dialog<>();
        DisplaySong.initOwner(DisplayBorder.getScene().getWindow());
        DisplaySong.setTitle("DisPlay Songs");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DisplaySongs.fxml"));
        try {
            DisplaySong.getDialogPane().setContent(fxmlLoader.load());
        }catch (IOException E){
            E.getStackTrace();
        }
        DisplaySong.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);
        System.out.println("BEFORE Show");
        //Optional<ButtonType> result = DisplaySong.showAndWait(); //removed this line too
        DisplaySong.show();

      // if(result.isPresent()){ REMOVED THIS LINE.
     // YOU FORGOT THE CAST HERE :
         DisplaySongs controller = (DisplaySongs) fxmlLoader.getController(); 
            controller.Display(AlbumAvailble.getSelectionModel().getSelectedItem());

}