public class App {
   public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.setBaseDir(Files.createTempDirectory("tomcat-basedir").toString());
        tomcat.addWebapp("/", Files.createTempDirectory("yourwebapp-doc-base").toString());
        tomcat.start();
        tomcat.getServer().await();
   }
}