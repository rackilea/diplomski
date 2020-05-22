public class ActionClass{

 // Making all methods for the actions you need to perform
 private static void loadData(){
    Reporter.log(description+"|"+data);
    driver.get(data);
    if(!TestBase.browserName.equals("Chrome"))
    {
    driver.manage().window().maximize();
    screenSize=driver.manage().window().getSize().toString();
    System.out.println("My screensize is "+screenSize);
    }       
}

private static void refreshPage(){
    driver.navigate().refresh();                         
    wait.until(ExpectedConditions.visibilityOfElementLocated(                        
    By.xpath("//span[contains(text(),'salesforce.com, inc. All rights 
    reserved.')]")));
}


private static void insertData(){
    Reporter.log(description+"|"+data);
    moveToElement(elementReference, referenceValue);
    findElement(elementReference, referenceValue).click();
    findElement(elementReference, referenceValue).clear();

    if (description.toLowerCase().contains("request name")||                         
    referenceValue.contains("reqNme")){
    String customNum=getDate("requestName");
    findElement(elementReference, referenceValue).sendKeys(data+customNum);
    System.out.println("Request Name is "+data+customNum);
    } else {
    findElement(elementReference, referenceValue).sendKeys(data);
    }
}


private static void uploadFile(){
    File file = new File(data);
    String filePath=file.getAbsolutePath();
    System.out.println(filePath);
    findElement(elementReference, referenceValue).clear();
    findElement(elementReference, referenceValue).sendKeys(filePath);
}

private static void uploadImageAction(){
    Reporter.log(description+"||"+data);
    uploadImage(elementReference, referenceValue, "Logo", new File(data));

}

private static void waitElVisibility(){
    wait = new WebDriverWait(driver,Long.parseLong(data));
    wait.until(ExpectedConditions.visibilityOf(findElement(elementReference, 
    referenceValue)));

}

private static void waitElInvisibility(){
    wait = new WebDriverWait(driver,Long.parseLong(data));
    wait.until(ExpectedConditions.invisibilityOfElementLocated(
    By.xpath(referenceValue)));

}

// The main method where switch condition will be present
    public static void main(String[] args) {
// Initialise the action string according to your code
    String action = null;
    switch (action) {
    case ("Load"):
        loadData();
        break;
    case ("RefreshPage"):
        refreshPage();
        break;

    case ("InsertData"):
        insertData();
        break;

    case ("uploadFile"):
        uploadFile();
        break;

    case ("uploadImage"):
        uploadImageAction();
        break;

    case ("waitElVisibility"):
        waitElVisibility();
        break;

    case ("waitElInVisibility"):
        waitElInvisibility();
        break;

    default:
        System.out.println("Action did not match");
    }
}