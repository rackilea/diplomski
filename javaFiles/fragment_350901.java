Select select = new Select(b.get(1).findElement(By.tagName("select")));

// Select by value (the attribute)
select.selectByValue("Helvetica");

// Select by visible text (the text inside the tag)
select.selectByVisibleText("Helvetica");