By byId = By.id("ctl00_mcp_ddlYear");

//use explicit wait to make sure the element is there
WebElement myDynamicElement = (new WebDriverWait(driver, 10))
  .until(ExpectedConditions.presenceOfElementLocated(byId));

Select dropdown = new Select(myDynamicElement);
dropdown.selectByValue("1997");