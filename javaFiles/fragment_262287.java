// input expiration date
driver.findElement(By.cssSelector("#passport-exp-date-input-243202807"))
      .sendKeys("2021-05-13");

// click any element on page which is not covered by the calendar pop-up
// to make the calendar close, so that it won't cover the Gender element
driver.findElement(<any element no covered by calendar>).click()

// if it's native dropdown,
// click on the dropdown to expand all options
// Generally, for native dropdown, no need to expand options
// we can directly click the option without expand all options.
driver.findElement(By.id("passport-gender-243202807")).click()

// click the wanted option
driver.findElement(By.id("passport-gender-243202807"))
      .findElement(By.xpath("./option[text()='Female']")).click()