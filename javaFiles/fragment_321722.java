ProtectionDomain domain = Main.class.getProtectionDomain();
    URL location = domain.getCodeSource().getLocation();
    WebAppContext webapp = new WebAppContext();
    webapp.setContextPath("/");
    webapp.setWar(location.toExternalForm());
    server.setHandler(webapp);