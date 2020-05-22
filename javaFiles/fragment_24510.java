public class CSharpDllHandler {

private static Logger log = Logger.getLogger(CSharpDllHandler.class);

public interface IFrameworkAdapter extends Library {

    public String runKeyword(String action, String xpath, String inputData,
            String verifyData);

    public String configureLog4net(String log4netConfigPath);

    public String loadAssemblies(String frameworkDllPath,
            String log4netDllPath);
}

private static IFrameworkAdapter jnaAdapterInstance = null;
private String jnaSearchPath = null;

public CSharpDllHandler(String searchPath) {
    this.jnaSearchPath = searchPath;
    // add to JNA search path
    System.setProperty("jna.library.path", jnaSearchPath);
    // load attempt
    jnaAdapterInstance = (IFrameworkAdapter) Native.loadLibrary(
            "FrameworkAdapter", IFrameworkAdapter.class);
}

public String loadAssemblies(String frameworkDllPath, String log4netDllPath) {
    String csResult = jnaAdapterInstance.loadAssemblies(frameworkDllPath,
            log4netDllPath);
    log.debug(csResult);
    return csResult;
}

public String runKeyword(String action, String xpath, String inputData,
        String verifyData) {
    String csResult = jnaAdapterInstance.runKeyword(action, xpath,
            inputData, verifyData);
    log.debug(csResult);
    return csResult;
}

public String configureLogging(String log4netConfigPath) {
    String csResult = jnaAdapterInstance
            .configureLog4net(log4netConfigPath);
    log.debug(csResult);
    return csResult;
}

public String getJnaSearchPath() {
    return jnaSearchPath;
}
}