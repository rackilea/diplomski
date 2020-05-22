private static void startManagementAgent(String pid) throws IOException {
    /*
     * JAR file normally in ${java.home}/jre/lib but may be in ${java.home}/lib
     * with development/non-images builds
     */
    String home = System.getProperty("java.home");
    String agent = home + File.separator + "jre" + File.separator + "lib"
            + File.separator + "management-agent.jar";
    File f = new File(agent);
    if (!f.exists()) {
        agent = home + File.separator + "lib" + File.separator +
            "management-agent.jar";
        f = new File(agent);
        if (!f.exists()) {
            throw new RuntimeException("management-agent.jar missing");
        }
    }
    agent = f.getCanonicalPath();

    System.out.println("Loading " + agent + " into target VM ...");

    try {
        VirtualMachine.attach(pid).loadAgent(agent);
    } catch (Exception x) {
        throw new IOException(x.getMessage());
    }
}