public class StartUpServlet extends RemoteServiceServlet {
    /**
     * This Servlet is used to set configuration file locations.
     */
    private static final long serialVersionUID = 6459940076859400546L;
    private final String CONFIG_FOLDER = "config";
    private final String LOG_FOLDER = "logs";

    public void init() {
        // Check the current of to have the good file separator for file
        // browsing
        String os = System.getProperty("os.name").toLowerCase();
        // windows
        String fileSeparator;
        if (os.indexOf("win") >= 0) {
            fileSeparator = "\\";
        } else {
            fileSeparator = "/";
        }

        String jaasConfigPath = super.getServletContext().getRealPath(
                CONFIG_FOLDER + fileSeparator + "JaasConfig.conf");
        String jaasConfigName = "JaasConfig";
        String configFile = super.getServletContext().getRealPath(
                CONFIG_FOLDER + fileSeparator + "config.properties");

        String log4j = getServletContext().getRealPath(
                CONFIG_FOLDER + fileSeparator + "log4j.properties");
        String logFile = getServletContext().getRealPath(
                LOG_FOLDER + fileSeparator + "vlplog.log");

        // Order is important here as the log4j properties file use the system
        // property : "logFile"
        System.setProperty("logFile", logFile);
        PropertyConfigurator.configure(log4j);
        System.setProperty("jaasConfigName", jaasConfigName);
        System.setProperty("jaasConfigPath", jaasConfigPath);
        System.setProperty("configFile", configFile);
    }
}