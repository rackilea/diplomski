WebElement Dropdown = driver.findElement(By.cssSelector("select#register-dob-month"));

Select select = new Select(Dropdown);

select.selectByIndex(4);
//or
select.deselectByVisibleText("May");