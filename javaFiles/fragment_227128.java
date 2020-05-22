if (properties.useSSL()) {
  ConnectHttp connect =
    ConnectHttp.toHostHttps(properties.urlSSL(), properties.portSSL())
      .withCustomHttpsContext(useHttps(system));

  Http.get(system).bindAndHandle(appRoute().flow(system, materializer),
      connect, materializer);
  log.info("Started on " + properties.urlSSL() + ":" + properties.portSSL());
}