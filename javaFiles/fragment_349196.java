private static DesiredCapabilities getCap() {
    DesiredCapabilities caps = DesiredCapabilities.chrome();
    LoggingPreferences logPrefs = new LoggingPreferences();
    logPrefs.enable(LogType.PERFORMANCE, Level.INFO);
    logPrefs.enable(LogType.PROFILER, Level.INFO);
    logPrefs.enable(LogType.BROWSER, Level.INFO);
    logPrefs.enable(LogType.CLIENT, Level.INFO);
    logPrefs.enable(LogType.DRIVER, Level.INFO);
    logPrefs.enable(LogType.SERVER, Level.INFO);
    caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
    return caps;
}