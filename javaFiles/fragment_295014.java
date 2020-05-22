static void setCurrentDir() throws URISyntaxException{
    String s;
    s = ESP8266_Configurator.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
    s = s.substring(0, s.lastIndexOf('/'));
    System.setProperty("user.dir",s);
}