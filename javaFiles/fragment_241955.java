public class SucheController {

    private MengeController mengeController ;

    public void setMengeController(MengeController mengeController) {
        this.mengeController = mengeController ;
    }

    // ...

    @FXML
    private void someHandlerMethod() {

        mengeController.setTextFieldValue("abc");

    }
}