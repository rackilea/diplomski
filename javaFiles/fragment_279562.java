public boolean checkOptions(String[] expected){
    WebElement select = driver.findElement(By.id("ctl00_cphMainContent_dq14_response"));
    List<WebElement> options = select.findElement(By.xpath(".//option"));
    int k = 0;
    for (WebElement opt : options){
        if (!opt.getText().equals(expected[k]){
            return false;
        }
        k = k + 1;
    }
    return true;
}