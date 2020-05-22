public class FileController {

    private Runnable onValidate = () -> {} ;

    public void setOnValidate(Runnable onValidate) {
        this.onValidate = onValidate ;
    }

    @FXML
    private void validerClickBE(ActionEvent event) {
        // whichever order you need....
        onValidate.run();
        System.out.println("here 2");
    }
}