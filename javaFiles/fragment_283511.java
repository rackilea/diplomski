public class MainController {
    public TextField userInputTextField;
    public Pane content;

    private FirstAreaController firstAreaController ;
    private SecondAreaController secondAreaController ;



    public void appendToFirstArea(ActionEvent actionEvent) {
        String text = userInputTextField.getText();
        firstAreaController.firstTextArea.appendText(text + "\n");
    }

    public void appendToSecondArea(ActionEvent actionEvent) {
        String text = userInputTextField.getText();
        secondAreaController.secondTextArea.appendText(text + "\n");
    }

    public void moveToFirstArea(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("first_area.fxml"));
            GridPane firstArea = loader.load();
            firstAreaController = loader.getController();
            content.getChildren().clear();
            content.getChildren().add(firstArea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moveToSecondArea(ActionEvent actionEvent) {
        try {
            FXMLLoader loader = getClass().getResource("second_area.fxml");
            GridPane secondArea = loader.load();
            secondAreaController = loader.getController();
            content.getChildren().clear();
            content.getChildren().add(secondArea);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}