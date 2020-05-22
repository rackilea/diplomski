WebElement monthSelector = driver.findElement(By.id("monthID"));
monthSelector.click();

if(monthSelector.isSelected())

   {

       Select sel = new Select(driver.findElement(By.id("monthID")));
       sel.selectByVisibleText("Your-dropdown-value");


   }
 else

   {
        System.out.println("Sorry , Dropdown not selected yet");


    }