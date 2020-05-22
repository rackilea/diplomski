FXMLLoader loader = new FXMLLoader(getClass().getResource("/your.fxml"));
    loader.setController(this);
    try {
        ContentPane.getChildren().add((Node)loader.load());
    } catch (IOException e){
        System.out.println(e.getMessage());
    }