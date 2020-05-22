Server server = new Server(8080);
HandlerList handlers = new HandlerList();
handlers.setHandlers(new Handler[]
{ someOtherHandler, new ShutdownHandler("secret password", false, true) });
server.setHandler(handlers);
server.start();