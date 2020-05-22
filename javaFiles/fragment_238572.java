private List<Node> middlePaneContent = new ArrayList<>();

@FXML
private AnchorPane middlePane;

@FXML
private void setMiddlePane(){
    // copy content to another list
    middlePaneContent.clear();
    middlePaneContent.addAll(middlePane.getChildren());

    //middlePane.setVisible(false);

    // clear child list
    middlePane.getChildren().clear();
}