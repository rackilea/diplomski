int sanitycount= 0;
int ec_Timeout = 10; //seconds to wait for list... 
    public void RunAction(WebDriver driver, String in_xpath)
    {
                  try
      {
        wait = new WebDriverWait(driver, ec_Timeout);
        List<WebElement> found_elements = new ArrayList<>();
        found_elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(in_xpath)));

        if (!found_elements.isEmpty())
        {
        // store this array, return an array from function
        // or loop through array and add items to more global array..
        }

       }
       catch (Exception e)
       {
       if (e.getClass().getCanonicalName().equals("org.openqa.selenium.StaleElementReferenceException"))
         {
         //need to do it again, not finished loading
         System.out.println("*****************Stale caught-redoing");
         sanitycount++;
         if (sanitycount<ec_Timeout * 2)
         {
         RunAction(driver, in_xpath);
         }
      System.out.println (e.toString());
      }
      else
      {
      System.out.println (e.toString());
      }
    }
  }
RunAction(your_driver, your_xpath); 
//set sanitycount back to zero if you run again...