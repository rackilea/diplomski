public class TestSortTable{

  static WebDriver driver;  

  public static void main(String[] args){

    driver = new FirefoxDriver();

    driver.manage().window().maximize();

    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    driver.get("http://www.datatables.net/examples/basic_init/table_sorting.html");

     //For Ascending in column "Position"
     String result = clickAndWaitForChangeText(By.xpath("//table[@id='example']//th[2]"), By.xpath("//table[@id='example']//tr[1]/td[2]"), "Ascending");

     if(result.contains("Fail"))
         System.err.println(result);
     else
         System.out.println(result);

     //For Descending in column "Position"
     result = clickAndWaitForChangeText(By.xpath("//table[@id='example']//th[2]"), By.xpath("//table[@id='example']//tr[1]/td[2]"),"Descending");

     if(result.contains("Fail"))
         System.err.println(result);
     else
         System.out.println(result);

    driver.close();//closing browser instance

}

//For clicking on header and waiting till the first text in the column changes
public static String clickAndWaitForChangeText(By Header_locator, By first_text_locator, String sortorder){

    try{

        String FirstText = driver.findElement(first_text_locator).getText();

        System.out.println("Clicking on the header for sorting in: "+sortorder); //sortorder -> String representing sort order Ascending/Descending

        driver.findElement(Header_locator).click();//Click for ascending/Descending

        //Below code will wait till the First Text changes for ascending/descending
        boolean b = new WebDriverWait(driver,10).until(ExpectedConditions.invisibilityOfElementWithText(first_text_locator, FirstText));

        if(b==true){
            return "Pass: Waiting Ends. Text has changed from '"+FirstText+"' to '"+driver.findElement(first_text_locator).getText()+"'";
        }
        else{
            return "Fail: Waiting Ends. Text hasn't changed from '"+FirstText+"'.";
        } 

    }catch(Throwable e){        
        return "Fail: Error while clicking and waiting for the text to change: "+e.getMessage();
    }

}