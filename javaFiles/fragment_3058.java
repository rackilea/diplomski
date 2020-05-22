public class Stage2Controller {

    @FXML
    private Label lb ;

    private Model model ;

    public void setModel(Model model) {
        lb.textProperty().unbind();
        this.model = model ;
        lb.textProperty().bind(model.textProperty());
    }

    // ...
}