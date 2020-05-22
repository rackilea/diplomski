private void updateLog4jConfiguration(String logFile) { 
    Properties props = new Properties(); 
    try { 
        InputStream configStream = getClass().getResourceAsStream( "/log4j.properties"); 
        props.load(configStream); 
        configStream.close(); 
    } catch (IOException e) { 
        System.out.println("Error: Cannot laod configuration file "); 
    } 
    props.setProperty("log4j.appender.FILE.file", logFile); 
    PropertyConfigurator.configure(props); 
 }