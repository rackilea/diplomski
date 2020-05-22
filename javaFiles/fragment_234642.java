public void initLogger() {
    Logger logger = Logger.getLogger("Q2"); //this creates a logger and register it with Q2 name
    org.jpos.util.DailyLogListener dayLog = new org.jpos.util.DailyLogListener();
    ProtectedLogListener pll = new ProtectedLogListener();
    Configuration protectLogCfg = new SimpleConfiguration();
    protectLogCfg.put("protect", "2");
    pll.setConfiguration(protectLogCfg);
    logger.addListener(pll);

    Configuration dayLogCfg = new SimpleConfiguration();
    dayLogCfg.put("window", "86400");
    dayLogCfg.put("prefix", logLocation);
    dayLogCfg.put("suffix", ".log");  
    dayLogCfg.put("date-format", "-yyyy-MM-dd");
    dayLog.setConfiguration(dayLogCfg);   
    logger.addListener(dayLog);
    logger.addListener(new SimpleLogListener(System.out)); 
    //all set now logger is accessible via Logger.getLogger
}