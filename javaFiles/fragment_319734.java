WebDriver driver = null;
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\vikas\\workspaceNeon\\Eclipse Soft\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.ebay.co.uk");

        WebElement myEbay = driver.findElement(By.linkText("My eBay"));
        myEbay.click();

        WebElement signInForm = driver.findElement(By.id("SignInForm"));

        if (signInForm.isDisplayed())
            System.out.println("Sign in form is displayed");

       driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

       WebElement username = driver.findElement(By.xpath("html/body/div[4]/div/div/div/div[5]/div/div[1]/div/div[1]/div[1]/div[2]/div/span/form/div[1]/div[5]/div/div[4]/span[2]/input"));

       username.sendKeys("Vikas");