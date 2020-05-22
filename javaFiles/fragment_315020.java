@FXML
private void initialize() {
    listTwo = FXCollections.observableArrayList();
    ListView<Response> lvTwo = new ListView<>(listTwo);
    lvTwo.setCellFactory(lv ->  new XCell());
    paneTwo.getChildren().add(lvTwo);

    listThree = FXCollections.observableArrayList();
    ListView<Response> lvThree = new ListView<>(listThree);
    lvThree.setCellFactory(l -> new XCell());
    paneThree.getChildren().add(lvThree);

    listFour = FXCollections.observableArrayList();
    ListView<Response> lvFour = new ListView<>(listFour);
    lvFour.setCellFactory(l -> new XCell());
    paneFour.getChildren().add(lvFour);

    listFive = FXCollections.observableArrayList();
    ListView<Response> lvFive = new ListView<>(listFive);
    lvFive.setCellFactory(l -> new XCell());
    paneFive.getChildren().add(lvFive);

    ...
}