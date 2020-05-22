public class ControllerClass {

    private final PauseTransition pauseBeforeSearch = new PauseTransition(Duration.millis(200));

    @FXML protected void keyReleased(KeyEvent evt)throws Exception {
       if (evt.getCode() != KeyCode.BACK_SPACE) {
           pauseBeforeSearch.setOnFinished(e -> {
               searchFrmDb(evt.getText(), new String[5]);
           });
           pauseBeforeSearch.playFromStart();
       }
    }

}