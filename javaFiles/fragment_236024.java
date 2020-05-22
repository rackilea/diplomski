button.setOnAction(event -> {
    Scene newScene = // ... commands which define the new scene.
    Stage stage = ((Node) event.getTarget()).getScene().getStage();
    // or alternatively, just:
    // Stage stage = button.getScene().getStage();
    stage.setScene(newScene);
});