public static void main(String[] args) throws IOException, InterruptedException {
        // TODO Auto-generated method stub
        File file = new File("IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        WebDriver driver = new InternetExplorerDriver();        
        driver.get("http://xx.xxx.xxx.xx/mysuite/Login.aspx");
        driver.findElement(By.id("txtUser")).sendKeys("administrator");
        driver.findElement(By.id("txtPwd")).sendKeys("password");
        driver.findElement(By.id("cmdLogin")).click();      
        //Click Add customer (customer child window opens)
        driver.findElement(By.linkText("Add Customer")).click();

        //Store before switch    
        String  mainHandle= driver.getWindowHandle();

        driver.switchTo().window("Customer");

        //Enter Customer ID and Save
        driver.findElement(By.id("txtCode")).sendKeys("1234");
        driver.findElement(By.id("cmdPageSave")).click();
                //Close the child window
        driver.findElement(By.id("cmdPageClose")).click();
        //swith back to parent window

        driver.switchTo().window(mainHandle);

        Thread.sleep(3000);
        driver.findElement(By.linkText("All customers")).click();

    }