/**
 * Utility method which exports and unpacks the WAR file into the Tomcat context directory
 * @param warName
 * @param contextPath
 * @return
 * @throws IOException
 * @throws URISyntaxException
 */
private static String exportWar(String warName, String contextPath) throws IOException, URISyntaxException {

    log.info("Beginning export WAR");
    try {
        UnzipUtility unzipUtility = new UnzipUtility();
        unzipUtility.unzip(warName, contextPath);
    } catch (IOException ex) {
        throw ex;
    }
    return contextPath + warName;
}