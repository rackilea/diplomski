private Boolean GetStatus()
{
    try {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(By.xpath("//div[@class='message_bubble']/span[@data-icon='ready_to_send']"), 1));
        return true;
    }catch (Exception e){
        return false;
    }
}