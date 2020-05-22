FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLView1.fxml"));
    try {
        paneView1 = loader.load();
        FXMLView1Controller view1Controller = loader.getController();
    }
    catch (IOException e) {
         ...
    }