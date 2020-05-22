public static void main(String[] args) throws Exception
{
    String jetty_home = "..";
    int appli_port = 8080;
    Server server = new Server(appli_port);
    ProtectionDomain protectionDomain = Loader.class.getProtectionDomain();
    URL location = protectionDomain.getCodeSource().getLocation();
    WebAppContext webapp = new WebAppContext();
    webapp.setContextPath("/");
    webapp.setWar(location.toExternalForm());

    // setup JNDI
    EnvConfiguration envConfiguration = new EnvConfiguration();
    URL url = new File("path to jetty-env.xml").toURI().toURL();
    envConfiguration.setJettyEnvXml(url);
    webapp.setConfigurations(new Configuration[] {new WebInfConfiguration(), envConfiguration, new WebXmlConfiguration()});

    server.setHandler(webapp); 
    server.start();
    server.join();
}