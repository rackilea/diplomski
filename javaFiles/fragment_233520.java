String xpath_rows = "//div[@class='ngCanvas']//div[contains(@class, 'Row')]";
String expectedIncidentNumber = "INC000006300863";
int numberOfRows = driver.findElements(By.xpath(xpath_rows)).size();
int matchedRow;

// Find out row number for **INC000006300863** incident number
for(int i=1; i<=numberOfRows; i++)
{

   if(driver.findElement(By.xpath(xpath_rows +"[" +i +"]//a[contains(text(), 'INC')]")).getText().equals(expectedIncidentNumber))
   {

      matchedRow = i;
      break;

   }

}

// Click on the checkbox present on the matched row
driver.findElement(By.xpath(xpath_rows +"[" +i +"]//input[@type='checkbox']")).click();