driver.get("https://stores.lenskart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElementById("OutletSearch").sendKeys("Chennai", Keys.ENTER);

List<WebElement> storedetails = driver.findElementsByXPath("//a[@title='Lenskart.com']/b");

int storecount = storedetails.size();
        System.out.println(storecount);


for(int i=1;i<=storecount;i++) {

            String storename = driver.findElementByXPath("//div[@class='border-manage store-info-box']["+i+"]/ul//b").getText();

            String storephonenumber = driver.findElementByXPath("//div[@class='border-manage store-info-box']["+i+"]/ul/li[6]").getText();

            System.out.println(storename + " : "+storephonenumber.substring(0, 13));
        }