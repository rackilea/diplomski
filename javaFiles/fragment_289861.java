// store the status strings in a List (makes comparisons easier)
List<String> statuses = Arrays.asList("Completed", "Successful", "Payroll Delayed", "Error");
// define the locator (not required but since it is so long, it makes later lines more readable)
By statusLocator = By.xpath("//table[@id='cppProcessInfoTable_rows_table']//tr[@id='cppProcessInfoTable_row_0']/td[starts-with(@id,'cppProcessInfoTable_row_0_cell_2')]");
// custom wait... wait for the text in the element to be one of the supplied statuses
new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
        public Boolean apply(WebDriver driver) {
            try {
              status = driver.findElement(statusLocator, driver).getText();
              return statuses.stream().anyMatch(str -> str.trim().equals(status));
            } catch (Exception e) {
              return false;
            }
          }
    });
// if we got here, the element contained a desired status
PS_OBJ_CycleData.Close(driver).click();