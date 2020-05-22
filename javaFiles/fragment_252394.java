public WebDriver driver;


    @Before
    public void setUp()

    {
        driver=new HtmlUnitDriver(BrowserVersion.FIREFOX_17);
       ((HtmlUnitDriver) driver).setJavascriptEnabled(true);
        driver.get("http://aviprobo.doorfree.com/control.html");


    }

    @Test
    public void testCase() 
   {

   for(int i=0;i<20;i++)
   {
   driver.findElement(By.xpath("//button[contains(.,'Up')]")).click();
    WebElement element = driver.findElement(By.id("control"));
   String text = element.getAttribute("value");
   System.out.println ("text = " + text);
   driver.findElement(By.xpath("//button[contains(.,'Down')]")).click();
   text = element.getAttribute("value");
   System.out.println ("text = " + text);
   driver.findElement(By.xpath("//button[contains(.,'Left')]")).click();
   text = element.getAttribute("value");
   System.out.println ("text = " + text);
   driver.findElement(By.xpath("//button[contains(.,'Right')]")).click();
   text = element.getAttribute("value");
   System.out.println ("text = " + text);
   driver.findElement(By.xpath("//button[contains(.,'Stop')]")).click();
   text = element.getAttribute("value");
   System.out.println ("text = " + text);
   }

   }