@Then("^the results should relate to \"([^\"]*)\"$")
    public void the_results_should_relate_to(String result) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("some element in page"))));
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains(result));
    }