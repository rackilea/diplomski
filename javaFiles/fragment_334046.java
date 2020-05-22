// variable server is of type org.eclipse.jetty.server.Server
environment.lifecycle().addServerLifecycleListener(new ServerLifecycleListener() {
    @Override
    public void serverStarted(Server server) {
      // ....
    }
});