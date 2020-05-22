package es.web.glassfish;

    import es.os.linux.Konsole;
    import java.io.IOException;

    /**
     *
     * @author adrian
     */
    public class Glassfish {

    private final static String glassfishPath = "/home/adrian/glassfish-4.0/";
    private final static String domainName = "domain1";

    public static String startGlassfishServer() throws IOException, InterruptedException {
        String command = glassfishPath + "bin/asadmin start-domain "+domainName;
        return Konsole.executeCommand(command);
    }

    public static String stopGlassfishServer() throws IOException, InterruptedException {
        String command = glassfishPath + "bin/asadmin stop-domain "+domainName;
        return Konsole.executeCommand(command);
    }

    public static String restrartGlassfishServer() throws IOException, InterruptedException {
        String command = glassfishPath + "bin/asadmin restart-domain "+domainName;
        return Konsole.executeCommand(command);
    }

}