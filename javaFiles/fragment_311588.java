version  = getClass().getPackage().getImplementationVersion();  
if (version==null) {
    Properties prop = new Properties();
    try {
        prop.load(getServletContext().getResourceAsStream("/META-INF/MANIFEST.MF"));
        version = prop.getProperty("Implementation-Version");
    } catch (IOException e) {
        logger.error(e.toString());
    }
}
logger.info("Starting App version "+version);