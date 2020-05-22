public void startAppium(String nodeJSExecutable, int nodeJSPort, String appiumJS, String mobileDeviceName,
    String androidVersion, String hsotMachineIP ) {
    RemoteWebDriver driver = null;
    String appURL = "http://www.w3schools.com/";

    File logFile = new File("D:/Yash/MyAppiumConsole_"+mobileDeviceName+".txt");
    File javaConsole = new File("D:/Yash/MyJavaConsole_"+mobileDeviceName+".txt");
    systemConsole2File( javaConsole );

    /*The hub only reads browserName, version, platform and applicationName.
    The other capabilities (deviceName, platformVersion, platformName, ...) are Appium capabilities, not used by the hub.*/     

    // Proxying straight through to Chromedriver
    DesiredCapabilities capabilities = DesiredCapabilities.android();
    /* Appium - io.appium.java_client.remote */
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,    "Appium" );
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,      "Android");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,   androidVersion );
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,        mobileDeviceName );
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,       "chrome"); // "Browser"
    capabilities.setCapability(MobileCapabilityType.UDID,               mobileDeviceName);

    /* Selenium - org.openqa.selenium.remote */
    capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, "true");        

    // Appium servers are nothing but the Node.js server        
    AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
                new AppiumServiceBuilder()
                .withAppiumJS( new File( appiumJS ) )
                .usingDriverExecutable( new File( nodeJSExecutable ) )
                .usingPort( nodeJSPort )
                .withIPAddress( hsotMachineIP )
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, nextFreePort().toString())
                .withArgument(AndroidServerFlag.CHROME_DRIVER_PORT, nextFreePort().toString())
                .withLogFile(logFile)
            );      
    service.start();

    System.out.println(" Appium Server Address [Local]: " + service.getUrl() );
    driver = new RemoteWebDriver( service.getUrl(), capabilities );     
    ...
}
public static final int HIGHEST_PORT = 65535;
public static final int LEAST_PORT = 1024;
public static Integer nextFreePort() {
    Integer port = (int)( Math.random() * 8000 ) + LEAST_PORT;
    while (true) {
        try ( ServerSocket endpoint = new ServerSocket(port) ) {
            System.out.println("Local Port on which this socket is listening :"+port);
            return port;
        } catch (IOException e) {
            port = ThreadLocalRandom.current().nextInt();
        }
    }
}
public static void systemConsole2File( File logFile ) {
    try ( FileOutputStream fos = new FileOutputStream( logFile );
          PrintStream system_console = new PrintStream( fos )
        ) {
        System.setOut( system_console ); // output stream.
        System.setErr( system_console ); // error output stream.
    } catch (IOException e) { 
        e.printStackTrace(); 
    }
}