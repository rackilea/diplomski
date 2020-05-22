// All your methods regarding stage changes are static, so I'll leave this one static too
public static void changeRoot(Stage stage, OwnPane newRoot){
    OwnPane oldStage = (OwnPane)stage.getScene().getRoot();
    oldStage.unsetAsRoot();
    Platform.runLater(() -> {   //Platform.runLater to be sure the main thread that will execute this 
                                //(only main thread is allowed to change something in the JavaFX nodes)
        stage.getScene().setRoot(newRoot);
        newRoot.setAsRoot();
    });
}