switch (key) {
    case "pin1" :
        List<WebElement> box1 = driver.findElements(By.cssSelector("div[class='field-set'] input[placeholder='1st']"));
        if(!box1.isEmpty()) {
            box1.get(0).sendKeys(value);
        }
        break;

    case "pin2" :
        List<WebElement> box2 = driver.findElements(By.cssSelector("div[class='field-set'] input[placeholder='2nd']"));
        if(!box2.isEmpty()) {
            box2.get(0).sendKeys(value);
        }
    break;

    case "pin3" :
        List<WebElement> box3 = driver.findElements(By.cssSelector("div[class='field-set'] input[placeholder='3rd']"));
        if(!box3.isEmpty()) {
            box3.get(0).sendKeys(value);
        }
    break;

    case "pin4" :
        List<WebElement> box4 = driver.findElements(By.cssSelector("div[class='field-set'] input[placeholder='4th']"));
        if(!box4.isEmpty()) {
            box4.get(0).sendKeys(value);
        }
    break;

    default :
        System.out.println("pincode textbox key not found");
    break;
}