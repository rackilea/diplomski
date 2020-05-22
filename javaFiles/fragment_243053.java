public class CustomBox extends HBox {

    private MainController mainController ;

    public CustomBox() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Custom.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController ;
    }

    public MainController getMainController() {
        return mainController ;
    }

    @FXML
    protected void show() {
        System.out.println(mainController.getText());
    }
}