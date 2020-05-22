static WebDriver driver;

    public static void main(String[] args) 
    {
        System.setProperty("webdriver.chrome.driver", "D:\\ToCustomer_31_5_13\\src\\main\\resources\\Drivers\\chromedriver.exe");
          driver = new FirefoxDriver();              
          driver.get("http://www.theatrepeople.com/");

          driver.findElement(By.id("edit-show")).click();
          WebElement show = driver.findElement(By.xpath("//div[@id = 'edit-show-wrapper']//div[@id = 'showNameWrap']"));
          List<WebElement> l = show.findElements(By.tagName("option"));
          String valueToSelect = getAttibuteValueForShow(l, "The American Plan");         
           driver.findElement(By.id("mini-basket-ajax")).click();
          selectValueInDropDown(valueToSelect);       
    }


    public static String getAttibuteValueForShow(List<WebElement> li, String showName)
    {
        int j =0;
        String value = null;
         for(int i =0; i<li.size(); i++)
         {
             j = j +1;
             String dropDownText = li.get(i).getText();
             if(dropDownText.equalsIgnoreCase(showName))
             {
                value =  driver.findElement(By.xpath("//div[@id = 'edit-show-wrapper']//div[@id = 'showNameWrap']//option[" + j +"]")).getAttribute("value");
                System.out.println(value);
                 break;
             }
         }
         return value;
    }

    public static void selectValueInDropDown(String value)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
         String jsCmd = "document.getElementsByName('show')[0].value='" + value + "'";
         js.executeScript(jsCmd);
    }