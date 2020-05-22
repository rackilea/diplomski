//i take string array for eight text field input value
String [] textToInput = {"first","second","Third","Fourth","Fifth","Sixth","Seventh","Eight"};

List<WebElement> elements =  driver.findElements(By.xpath(".//*[@id='placement_link']"));

System.out.println("size is "+elements.size());

for(int i = 0; i < elements.size(); i++){
        elements.get(i).sendKeys(textToInput[i]);
    }