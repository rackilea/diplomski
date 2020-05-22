public static void main(String[] args) 
{


      // Create proxy class object
      Proxy p=new Proxy();

      // Set HTTP Port to 7777
      p.setHttpProxy("localhost:7777");

      // Create desired Capability object
      DesiredCapabilities cap=new DesiredCapabilities();


      // Pass proxy object p
      cap.setCapability(CapabilityType.PROXY, p);
      System.setProperty("webdriver.gecko.driver", "//PATH");
      WebDriver driver=new FirefoxDriver(cap);

 }