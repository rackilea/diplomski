final HttpServer server = new org.glassfish.grizzly.http.server.HttpServer();
server.addListener(new NetworkListener("grizzly", "localhost", 8080));
server.getServerConfiguration().addHttpHandler(
    new StaticHttpHandler("/var/www/"), "/");

server.getServerConfiguration().getMonitoringConfig().getWebServerConfig()
  .addProbes(new HttpServerProbe.Adapter() {

    @Override
    public void onRequestReceiveEvent(
        HttpServerFilter filter,
        Connection connection,
        Request request) {

      System.out.println(request.getRemoteAddr());
      MDC.put("http-client", request.getRemoteAddr());
    }

    @Override
    public void onRequestCompleteEvent(
        HttpServerFilter filter,
        Connection connection,
        Response response) {

      MDC.remove("http-client");
    }
}

server.start();