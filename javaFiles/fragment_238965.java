//Get Current Page 
String currentPageHandle = driver.getWindowHandle();                
linkToClick.click();        

//Add Logic to Wait till Page Load 

// Get all Open Tabs
ArrayList<String> tabHandles = new ArrayList<String>(driver.getWindowHandles());

String pageTitle = "ThePageTitleIhaveToCheckFor";
boolean myNewTabFound = false;

for(String eachHandle : tabHandles)
{
    driver.switchTo().window(eachHandle);
    // Check Your Page Title 
    if(driver.getTitle().equalsIgnoreCase(pageTitle))
    {
        // Report ur new tab is found with appropriate title 

        //Close the current tab
        driver.close(); // Note driver.quit() will close all tabs

        //Swithc focus to Old tab
        driver.switchTo().window(currentPageHandle);
        myNewTabFound = true;           
    }
}

if(myNewTabFound)
{
    // Report page not opened as expected       
}