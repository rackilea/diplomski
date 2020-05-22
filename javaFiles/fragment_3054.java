public class Stage1Controller {

    private final Stage2Controller stage2Controller ;

    public void setStage2Controller(Stage2Controller stage2Controller) {
        this.stage2Controller = stage2Controller ;
    }

    // ...

    @FXML 
    private void handleTranslate (ActionEvent event){
        translateFirstStage();
        stage2Controller.setLabel(...);
    }

    // other code as before ...
}