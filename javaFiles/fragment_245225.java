//To select year
List<WebElement> select_year = driver.findElements(By.xpath("//ul[@class='uib-datepicker-popup dropdown-menu ng-scope']/li/div/table/tbody/tr/td/button/span"));
 for(WebElement ele: select_year)
{
    String fyear=ele.getText();
    if((syear).equals(fyear))
    {
        ele.click();
        break;
    }
 }

//To select month 
List<WebElement> select_month = driver.findElements(By.xpath("//ul[@class='uib-datepicker-popup dropdown-menu ng-scope']/li/div/table/tbody/tr/td/button/span"));
 for(WebElement ele: select_year)
{
    String fmonth = ele.getText();
    if((smonth).equals(fmonth))
    {
        ele.click();
        break;
    }
 }

//To select day
List<WebElement> select_day = driver.findElements(By.xpath("//ul[@class='uib-datepicker-popup dropdown-menu ng-scope']/li/div/table/tbody/tr/td/button/span"));
 for(WebElement ele: select_year)
{
    String fday = ele.getText();
    if((sday).equals(fday))
    {
        ele.click();
        break;
    }
 }