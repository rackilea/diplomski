boolean controllerExisted = chatAgentsMap.containsKey(agentKey) ;

ChatAgentsController chatController = chatAgentsMap.computeIfAbsent(agentKey, k -> {
    LOGGER.message(String.format("Creating chat window for agent '%d'.", k)); 
    return ChatAgentsController.create(this, k, connectedToOpenfireServer, true);
});

if (controllerExisted) {
    // chat window has been created
    // chatController = chatAgentsMap.get(agentKey);
    LOGGER.message(String.format("Showing chat window for agent '%d'.", agentKey));                    
    if(!chatController.getChatStage().isFocused()){
        toastStage.show();
        chatController.getChatStage().show();
    }
} else {

    // chatController = ChatAgentsController.create(this, agentKey, connectedToOpenfireServer, true);
    toastStage.show();
    toastStage.setAlwaysOnTop(true);

     //-----Here is where I want that the toastStage or the toastScene is clickable by mouse and that it opens the window already created chatController

    toastScene.setOnMouseClicked( e -> chatController.getChatStage().show());

    // chatAgentsMap.put(agentKey, chatController);
}