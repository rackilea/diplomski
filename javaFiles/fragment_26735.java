primaryStage.setOnCloseRequest(event -> {
    event.consume();
    mainContainer.setScreen(screenManageBanksId);
});

...

primaryStage.setOnCloseRequest(event -> {
    event.consume();
    mainContainer.getManageBanksController().logoutAdmin();
});