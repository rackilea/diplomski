private WebDriver driver = null;

public void openHeadless() throws Exception
{
    FirefoxBinary binary = new FirefoxBinary(new File("/usr/local/bin/firefox"));
    binary.setEnvironmentProperty("DISPLAY",System.getProperty("lmportal.xvfb.id",":99"));
    driver = new FirefoxDriver(binary,null);
}