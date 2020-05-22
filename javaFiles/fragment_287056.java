WebDriverWait wait = new WebDriverWait(driver, 300);
WebElement triggerDropDown = driver.findElement(By
                .className("ui-helper-hidden"));
triggerDropDown.click();
WebElement selectElement = wait.until(ExpectedConditions
                  .visibilityOfElementLocated(By.id("formLevel:levels_input")));
Select select = new Select(selectElement);
select.selectByVisibleText("SECURITY");