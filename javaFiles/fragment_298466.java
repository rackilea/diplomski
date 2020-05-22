sl.getOptions().get(i).click();

By hcdataBy = By.xpath("//form/div/div[3]/div[2]/div[1]/p");
//this would wait up to 10 seconds for the wait condition. Change the 2nd parameter if longer or shorter would be better.
WebDriverWait wait = new WebDriverWait(driver, 10);
wait.until(new ExpectedCondition<Boolean>(){
    public Boolean apply(WebDriver d) {
        return d.findElement(hcdataBy).getText().length() > 0;
    }
});