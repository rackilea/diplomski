public class Stage1Controller {

    private Model model ;

    public void setModel(Model model) {
        this.model = model ;
    }

    @FXML 
    private void handleTranslate (ActionEvent event){
        translateFirstStage();

        model.setText(...); // value will appear in stage2 controller's label!
    }

    // ...
}