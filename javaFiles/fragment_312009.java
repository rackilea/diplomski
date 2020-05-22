public static <T> T showWindow(String path){
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(ShowWindow.class.getResource(path));
        Parent root = fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setScene(new Scene(root));
        stage.showAndWait();
        return fxmlLoader.getController();
    }catch(IOException ex){
        ex.printStackTrace();
    }
    return null;
}