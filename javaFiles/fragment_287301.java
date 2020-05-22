WebDriver driver = new FirefoxDriver();
        driver.get("http://www.cleartrip.com/");

        WebElement From = driver.findElement(By.id("FromTag"));

        From.sendKeys("Del");

        WebElement autoComplete = driver.findElement(By.id("ui-id-1"));

        try{
            (new WebDriverWait(driver, 5/*sec*/)).
                    until(ExpectedConditions.presenceOfElementLocated((By.cssSelector("li.list"))));             }
        catch(org.openqa.selenium.TimeoutException e){
            System.out.println(e.getMessage());
        }

        List<WebElement> autoCompleteList = autoComplete.findElements(By.className("list"));

        if(autoCompleteList.size()==0) {
            System.out.println("autoComplete list NOT found");
        }
        else {
            System.out.println("autoComplete list Found with elements: "+autoCompleteList.size());
        }

        for (WebElement ac: autoCompleteList){
            if(ac.getText().contains("Delhi")){  
                ac.click();
                break;
            }
        }
        driver.close();