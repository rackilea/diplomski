WebAppContext context = new WebAppContext();
context.setContextPath("/myWebApp");
context.setExtractWAR(false);
context.setDescriptor("/file/system/path/to/your/wab/app/WEB-INF/web.xml");
context.setResourceBase("/file/system/path/to/your/wab/app");
context.setConfigurationDiscovered(false);

HandlerList handlerList=new HandlerList();
handlerList.addHandler(webAppContext);

Server server = new Server(threadPool);
server.setHandler(handlerList);
server.start();