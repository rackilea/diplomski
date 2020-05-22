String serverContainerClass = ServerContainer.class.getName();
    //should be "javax.websocket.server.ServerContainer", if not, some external package could have hogged the implementation
    final ServerContainer serverContainer = (ServerContainer) context.getServletContext().getAttribute(serverContainerClass);
    try 
    {
        serverContainer.addEndpoint(WebSocket.class);
    } 
    catch (DeploymentException e)
    {
        TraceWriter.Error(this, "Failed to initialize websocket", e);
    }